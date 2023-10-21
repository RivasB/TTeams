package cloud.tteams.comment.comment.domain.service;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.CommentId;
import org.springframework.data.domain.Pageable;

public interface ICommentDomainService {
    void create(Comment project);

    void update(Comment project);

    void delete(CommentId projectId);

    Comment findById(CommentId id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
