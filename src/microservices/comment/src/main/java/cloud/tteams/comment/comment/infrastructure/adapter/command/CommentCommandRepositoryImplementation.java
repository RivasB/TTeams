package cloud.tteams.comment.comment.infrastructure.adapter.command;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.comment.comment.infrastructure.adapter.query.ICommentQueryJPARepository;
import cloud.tteams.comment.comment.infrastructure.exception.CommentNotFoundException;
import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Primary
public class CommentCommandRepositoryImplementation implements ICommentCommandRepository {

    private final ICommentCommandJPARepository jpaRepository;

    private final ICommentQueryJPARepository readDataJPARepository;

    public CommentCommandRepositoryImplementation(final ICommentCommandJPARepository jpaRepository, ICommentQueryJPARepository readDataJPARepository) {
        this.jpaRepository = jpaRepository;
        this.readDataJPARepository = readDataJPARepository;
    }

    @Override
    public void create(Comment comment) {
        jpaRepository.save(new CommentEntity(comment));
    }

    @Override
    public void update(Comment comment) {
        jpaRepository.save(new CommentEntity(comment));
    }

    @Override
    public Comment delete(UUID commentId) {
        CommentEntity toDelete =
                readDataJPARepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
        toDelete.setDeleted(true);
        return jpaRepository.save(toDelete).toAggregate();
    }
}
