package cloud.tteams.comment.comment.infrastructure.service;


import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.comment.comment.domain.CommentId;
import cloud.tteams.comment.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.comment.comment.domain.repository.ICommentQueryRepository;
import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class ProjectDomainServiceImplementation implements ICommentDomainService {

    private final ICommentCommandRepository commandRepository;

    private final ICommentQueryRepository queryRepository;

    private final IEventService<Comment> eventService;

    private final Log logger = LogFactory.getLog(this.getClass());

    @Value("${kafka.messenger.comment:true}")
    private boolean messengerIsActive;

    public ProjectDomainServiceImplementation(ICommentCommandRepository commandRepository, ICommentQueryRepository queryRepository,
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
        Field[] fields = comment.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object valueStation = attrib.get(comment);
                Object valueToUpdateStation = attrib.get(toUpdateComment);
                if (valueStation != null && !valueStation.equals(valueToUpdateStation)
                        && attrib.getType().isAssignableFrom(valueStation.getClass())) {
                    attrib.set(toUpdateComment, valueStation);
                }
            }
        } catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        commandRepository.update(toUpdateComment);
        publishEvent(toUpdateComment, EventType.UPDATED);
    }

    @Override
    public void delete(CommentId commentId) {
        Comment comment = this.findById(commentId);
        commandRepository.delete(commentId);
        publishEvent(comment, EventType.DELETED);
    }

    @Override
    public Comment findById(CommentId id) {
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
                    eventService.create(data);
                    break;
                case UPDATED:
                    eventService.update(data);
                    break;
                case DELETED:
                    eventService.delete(data);
                    break;
                default:
                    // do nothing
            }
        }
    }

}
