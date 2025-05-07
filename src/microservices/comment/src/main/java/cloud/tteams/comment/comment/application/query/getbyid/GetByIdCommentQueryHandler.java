package cloud.tteams.comment.comment.application.query.getbyid;

import cloud.tteams.comment.comment.application.CommentResponse;
import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class GetByIdCommentQueryHandler implements IQueryHandler<GetByIdCommentQuery, CommentResponse> {

    private final ICommentDomainService commentDomainService;

    public GetByIdCommentQueryHandler(ICommentDomainService commentDomainService) {
        this.commentDomainService = commentDomainService;
    }

    @Override
    public CommentResponse handle(GetByIdCommentQuery query) {
        Comment comment = commentDomainService.findById(query.getId());
        return new CommentResponse(comment);
    }
}
