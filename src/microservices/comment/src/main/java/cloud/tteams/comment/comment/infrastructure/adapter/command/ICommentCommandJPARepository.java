package cloud.tteams.comment.comment.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentCommandJPARepository extends JpaRepository<CommentEntity, UUID> {

}
