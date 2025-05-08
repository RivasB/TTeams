package cloud.tteams.comment.comment.domain;


import cloud.tteams.comment.comment.domain.rules.AuthorValidation;
import cloud.tteams.comment.comment.domain.rules.BodyMinAndMaxExtension;
import cloud.tteams.share.core.domain.rules.RulesChecker;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Comment {
    private final UUID id;

    private String author;

    private final UUID task;

    private final String body;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Comment(UUID id, String author, UUID task, String body, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.author = author;
        this.task = task;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Comment(UUID id, String author, UUID task, String body) {
        this.id = id;
        this.author = author;
        this.task = task;
        this.body = body;
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

    public UUID getTask() {
        return task;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
