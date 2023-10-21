package cloud.tteams.comment.comment.domain.repository;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.CommentId;

public interface ICommentCommandRepository {

    void create(Comment project);

    void update(Comment project);

    void delete(CommentId projectId);
}
