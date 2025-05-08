package cloud.tteams.comment.comment.infrastructure.repository.hibernate;
import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.infrastructure.repository.hibernate.Auditable;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "tteams_comment")
@Where(clause = "deleted = false")
public class CommentEntity extends Auditable {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private UUID task;

    @Column(nullable = false, columnDefinition = "VARCHAR(4000)")
    private String body;

    @Column(nullable = false)
    private boolean deleted = false;


    public CommentEntity() {
    }

    public CommentEntity(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.task = comment.getTask();
        this.body = comment.getBody();
    }

    public Comment toAggregate() {
        return new Comment(
                this.id,
                this.author,
                this.task,
                this.body,
                fromDateToLocalDateTime(super.getCreatedDate()),
                fromDateToLocalDateTime(super.getLastModifiedDate()));
    }

    private LocalDateTime fromDateToLocalDateTime(Date date){
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void update(Comment comment){
        Optional.ofNullable(comment.getBody()).ifPresent(valor ->
                this.body = valor);
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public UUID getTask() {
        return task;
    }

    public String getBody() {
        return body;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
