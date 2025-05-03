package cloud.tteams.comment.comment.infrastructure.service;


import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.comment.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.comment.comment.domain.repository.ICommentQueryRepository;
import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentDomainServiceImplementation implements ICommentDomainService {

    private final ICommentCommandRepository commandRepository;

    private final ICommentQueryRepository queryRepository;

    private final IEventService<Comment> eventService;

    private final Log logger = LogFactory.getLog(this.getClass());

    @Value("${kafka.messenger.comment:true}")
    private boolean messengerIsActive;

    public CommentDomainServiceImplementation(ICommentCommandRepository commandRepository, ICommentQueryRepository queryRepository,
                                              IEventService<Comment> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void create(Comment comment) {
        commandRepository.create(comment);
        publishEvent(comment, EventType.CREATED);
    }

    @Override
    public void update(Comment comment) {
        Comment toUpdateComment = findById(comment.getId());
        toUpdateComment.update(comment);
        commandRepository.update(toUpdateComment);
        publishEvent(toUpdateComment, EventType.UPDATED);
    }

    @Override
    public void delete(UUID commentId) {
        Comment comment = this.findById(commentId);
        commandRepository.delete(commentId);
        publishEvent(comment, EventType.DELETED);
    }

    @Override
    public Comment findById(UUID id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

    private void publishEvent(Comment data, EventType type){
        if (messengerIsActive){
            switch(type) {
                case CREATED:
                    eventService.publish(data);
                    logData(data,type);
                    break;
                case UPDATED:
                    eventService.update(data);
                    logData(data,type);
                    break;
                case DELETED:
                    eventService.delete(data);
                    logData(data,type);
                    break;
                default:
                    // do nothing
            }
        }
    }

    private void logData(Comment data, EventType type){
        logger.info(String.format("Comment with ID: << %s >> was %s successfully.", data.getId(), type.toString()));
    }

}
