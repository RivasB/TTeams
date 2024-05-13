package cloud.tteams.share.comment.domain.repository;

import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.comment.domain.CommentId;
import org.springframework.data.domain.Pageable;

public interface ICommentQueryRepository {

    Comment findById(CommentId id);

    MessagePaginatedResponse findAll(Pageable pageable);

    }
