package cloud.tteams.comment.comment.infrastructure.adapter.query;


import cloud.tteams.comment.comment.infrastructure.repository.hibernate.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICommentQueryJPARepository extends JpaRepository<CommentEntity, UUID> {
    Page<CommentEntity> findAllByTask(UUID task, Pageable pageable);
}
