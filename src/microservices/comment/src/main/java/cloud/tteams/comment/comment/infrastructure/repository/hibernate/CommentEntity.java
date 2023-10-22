package cloud.tteams.comment.comment.infrastructure.repository.hibernate;
import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.CommentId;
import cloud.tteams.comment.comment.domain.CommentAssociatedEntityType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tteams_project")
public class CommentEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "status")
    private CommentAssociatedEntityType status;

    public CommentEntity() {
    }

    public CommentEntity(Comment project) {
        this.id = project.getId().value();
        this.status = null;
    }

    public Comment toAggregate() {
        CommentId id = new CommentId(this.id);
        CommentAssociatedEntityType status = this.status;
        return null;
    }

    public UUID getId() {
        return id;
    }
}
