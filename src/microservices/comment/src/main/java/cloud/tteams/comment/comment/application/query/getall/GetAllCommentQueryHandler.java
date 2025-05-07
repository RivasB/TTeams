package cloud.tteams.comment.comment.application.query.getall;

import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetAllCommentQueryHandler implements IQueryHandler<GetAllCommentQuery, MessagePaginatedResponse> {

    private final ICommentDomainService commentDomainService;

    public GetAllCommentQueryHandler(ICommentDomainService commentDomainService) {
        this.commentDomainService = commentDomainService;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllCommentQuery query) {
        if ( !query.getTask().isEmpty() || !query.getTask().isBlank() || query.getTask() != null) {
            try {
                UUID taskId = UUID.fromString(query.getTask());
                return commentDomainService.findAllByTask(taskId, query.getPageable());
            }
            catch (Exception e) {
                throw new IllegalArgumentException("Invalid task ID format: " + query.getTask(), e);
            }
        }
        else {
            return commentDomainService.findAll(query.getPageable());
        }
    }
}
