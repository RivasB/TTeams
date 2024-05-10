package cloud.tteams.comment.comment.application;

import cloud.tteams.comment.comment.domain.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommentResponse {

    private UUID id;

    private String author;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String body;

    public CommentResponse() {
    }

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.body = comment.getBody();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
