package cloud.tteams.share.comment.domain.service;


import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.comment.domain.CommentId;
import org.springframework.data.domain.Pageable;

public interface ICommentDomainService {
    void create(Comment project);

    void update(Comment project);

    void delete(CommentId projectId);

    Comment findById(CommentId id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
