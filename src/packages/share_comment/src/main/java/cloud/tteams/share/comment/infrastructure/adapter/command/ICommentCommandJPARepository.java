package cloud.tteams.share.comment.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.share.comment.infrastructure.repository.hibernate.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentCommandJPARepository extends JpaRepository<CommentEntity, UUID> {

}
