package cloud.tteams.comment.comment.application;

import cloud.tteams.comment.comment.domain.*;
import cloud.tteams.share.core.domain.bus.query.IResponse;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommentResponse implements IResponse {

    private UUID id;

    private String author;

    private UUID task;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String body;

    public CommentResponse() {
    }

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.task = comment.getTask();
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

    public UUID getTask() {
        return task;
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
