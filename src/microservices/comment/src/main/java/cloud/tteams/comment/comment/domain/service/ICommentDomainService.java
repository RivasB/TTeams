package cloud.tteams.comment.comment.domain.service;


import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.comment.comment.domain.Comment;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ICommentDomainService {
    void create(Comment comment);

    void update(Comment comment);

    void delete(UUID commentId);

    Comment findById(UUID commentId);

    MessagePaginatedResponse findAll(Pageable pageable);

    MessagePaginatedResponse findAllByTask(UUID task, Pageable pageable);

}
