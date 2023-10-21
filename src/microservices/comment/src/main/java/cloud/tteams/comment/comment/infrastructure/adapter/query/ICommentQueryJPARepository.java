package cloud.tteams.comment.comment.infrastructure.adapter.query;


import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICommentQueryJPARepository extends JpaRepository<CommentEntity, UUID> {

}
