package cloud.tteams.comment.comment.infrastructure.adapter.query;


import cloud.tteams.comment.comment.application.CommentResponse;
import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.repository.ICommentQueryRepository;
import cloud.tteams.comment.comment.infrastructure.exception.CommentNotFoundException;
import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Primary
public class CommentQueryRepositoryImplementation implements ICommentQueryRepository {
    private final ICommentQueryJPARepository jpaRepository;

    public CommentQueryRepositoryImplementation(final ICommentQueryJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Comment findById(UUID id) {
        CommentEntity commentEntity = jpaRepository.findById(id)
                .orElseThrow(CommentNotFoundException::new);
        return commentEntity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<CommentEntity> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }


    private MessagePaginatedResponse result(Page<CommentEntity> page) {
        List<CommentResponse> response = page.stream()
                .map(item -> new CommentResponse(item.toAggregate())).toList();
        return new MessagePaginatedResponse(response, page);
    }

}
