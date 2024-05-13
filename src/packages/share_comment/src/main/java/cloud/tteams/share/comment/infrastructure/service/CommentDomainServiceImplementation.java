package cloud.tteams.share.comment.infrastructure.service;


import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.comment.domain.CommentId;
import cloud.tteams.share.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.share.comment.domain.repository.ICommentQueryRepository;
import cloud.tteams.share.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class CommentDomainServiceImplementation implements ICommentDomainService {

    private final ICommentCommandRepository commandRepository;

    private final ICommentQueryRepository queryRepository;

    private final Log logger = LogFactory.getLog(this.getClass());

    public CommentDomainServiceImplementation(ICommentCommandRepository commandRepository,
                                              ICommentQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    @Override
    public void create(Comment comment) {
        commandRepository.create(comment);
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
    }

    @Override
    public void delete(CommentId commentId) {
        commandRepository.delete(commentId);
    }

    @Override
    public Comment findById(CommentId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

}
