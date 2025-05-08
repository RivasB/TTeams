package cloud.tteams.comment.comment.application.query.getall;

import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class GetAllCommentQueryHandler implements IQueryHandler<GetAllCommentQuery, MessagePaginatedResponse> {

    private final ICommentDomainService commentDomainService;

    public GetAllCommentQueryHandler(ICommentDomainService commentDomainService) {
        this.commentDomainService = commentDomainService;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllCommentQuery query) {
        if (query.getTask() != null) {
            return commentDomainService.findAllByTask(query.getTask(), query.getPageable());
        }
        else {
            return commentDomainService.findAll(query.getPageable());
        }
    }
}
