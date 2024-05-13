package cloud.tteams.comment.comment.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@CommandRepository
public interface ICommentCommandJPARepository extends JpaRepository<CommentEntity, UUID> {

}
