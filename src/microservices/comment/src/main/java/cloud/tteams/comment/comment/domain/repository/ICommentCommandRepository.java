package cloud.tteams.comment.comment.domain.repository;

import cloud.tteams.comment.comment.domain.Comment;

import java.util.UUID;

public interface ICommentCommandRepository {

    void create(Comment project);

    void update(Comment project);

    Comment delete(UUID projectId);
}
