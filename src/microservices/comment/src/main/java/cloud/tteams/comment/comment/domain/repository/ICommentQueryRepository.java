package cloud.tteams.comment.comment.domain.repository;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ICommentQueryRepository {

    Comment findById(UUID id);

    MessagePaginatedResponse findAll(Pageable pageable);

    }
