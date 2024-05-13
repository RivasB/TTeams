package cloud.tteams.comment.comment.infrastructure.repository.hibernate;
import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import cloud.tteams.share.core.infrastructure.config.annotation.Persistent;
import cloud.tteams.share.core.infrastructure.repository.hibernate.Auditable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Entity
@Persistent
@Table(name = "tteams_comment")
public class CommentEntity extends Auditable {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String body;


    public CommentEntity() {
    }

    public CommentEntity(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.body = comment.getBody();
    }

    public Comment toAggregate() {
        return new Comment(
                this.id,
                this.author,
                this.body,
                fromDateToLocalDateTime(super.getCreatedDate()),
                fromDateToLocalDateTime(super.getLastModifiedDate()));
    }

    private LocalDateTime fromDateToLocalDateTime(Date date){
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
