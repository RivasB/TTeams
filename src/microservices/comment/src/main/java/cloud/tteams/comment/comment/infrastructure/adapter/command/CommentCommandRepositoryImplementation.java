package cloud.tteams.comment.comment.infrastructure.adapter.command;

import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.comment.comment.domain.rules.AuthorValidation;
import cloud.tteams.comment.comment.domain.rules.BodyMinAndMaxExtension;
import cloud.tteams.comment.comment.infrastructure.adapter.query.ICommentQueryJPARepository;
import cloud.tteams.comment.comment.infrastructure.exception.CommentNotFoundException;
import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.rules.RulesChecker;
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
        String author = getAuthorFromSession();
        comment.setAuthor(author);
        RulesChecker.checkRule(new BodyMinAndMaxExtension(comment.getBody()));
        jpaRepository.save(new CommentEntity(comment));
    }

    @Override
    public Comment update(Comment comment) {
        String author = getAuthorFromSession();
        CommentEntity entity = getEntity(comment.getId());
        RulesChecker.checkRule(new AuthorValidation(entity.getAuthor(), author));
        RulesChecker.checkRule(new BodyMinAndMaxExtension(comment.getBody()));
        entity.update(comment);
        return jpaRepository.save(entity).toAggregate();
    }

    @Override
    public Comment delete(UUID commentId) {
        String author = getAuthorFromSession();
        CommentEntity toDelete =
                getEntity(commentId);
        RulesChecker.checkRule(new AuthorValidation(toDelete.getAuthor(), author));
        toDelete.setDeleted(true);
        return jpaRepository.save(toDelete).toAggregate();
    }

    private CommentEntity getEntity(UUID commentId) {
        return readDataJPARepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
    }

    private static String getAuthorFromSession() {
        return UserContext.getUserSession() != null ? UserContext.getUserSession().getUsername() : "unknown/system";
    }
}
