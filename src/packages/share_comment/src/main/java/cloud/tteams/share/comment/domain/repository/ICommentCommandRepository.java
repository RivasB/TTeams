package cloud.tteams.share.comment.domain.repository;

import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.comment.domain.CommentId;

public interface ICommentCommandRepository {

    void create(Comment project);

    void update(Comment project);

    void delete(CommentId projectId);
}
