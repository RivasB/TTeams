package cloud.tteams.comment.comment.infrastructure.adapter.query;


import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import cloud.tteams.share.core.infrastructure.config.annotation.QueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@QueryRepository
public interface ICommentQueryJPARepository extends JpaRepository<CommentEntity, UUID> {

}
