package cloud.tteams.comment.comment.infrastructure.service;


import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.comment.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.comment.comment.domain.repository.ICommentQueryRepository;
import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Transactional
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
        Comment comment = commandRepository.delete(commentId);
        logData(comment, EventType.DELETED);
    }

    @Override
    public Comment findById(UUID id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

    @Override
    public MessagePaginatedResponse findAllByTask(UUID task, Pageable pageable) {
        return queryRepository.findAllByTask(task, pageable);
    }

    private void publishEvent(Comment data, EventType type){
        logData(data, type);
        if (messengerIsActive){
            eventService.publish(type, data);
        }
    }

    private void logData(Comment data, EventType type){
        logger.info(String.format("Comment with ID: << %s >> was %s successfully.", data.getId(), type.toString()));
    }

}
