package cloud.tteams.share.comment.infrastructure.adapter.command;

import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.comment.domain.CommentId;
import cloud.tteams.share.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.share.comment.infrastructure.adapter.query.ICommentQueryJPARepository;
import cloud.tteams.share.comment.infrastructure.exception.CommentNotFoundException;
import cloud.tteams.share.comment.infrastructure.repository.hibernate.CommentEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

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
    public void delete(CommentId commentId) {
        CommentEntity toDelete =
                readDataJPARepository.findById(commentId.getValue()).orElseThrow(CommentNotFoundException::new);
        jpaRepository.delete(toDelete);
    }
}
