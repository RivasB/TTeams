package cloud.tteams.comment.comment.domain.repository;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.comment.comment.domain.CommentId;
import org.springframework.data.domain.Pageable;

public interface ICommentQueryRepository {

    Comment findById(CommentId id);

    MessagePaginatedResponse findAll(Pageable pageable);

    }
