package cloud.tteams.share.comment.application;

import cloud.tteams.comment.comment.domain.*;
import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.comment.domain.CommentAssociatedEntityType;
import cloud.tteams.share.user.application.SimpleUserResponse;

import java.time.LocalDate;
import java.util.UUID;

public class CommentResponse {
    private final UUID id;

    private final UUID associatedEntityId;

    private final CommentAssociatedEntityType associatedEntityType;

    private final SimpleUserResponse author;

    private final String body;

    private final LocalDate createdAt;

    public CommentResponse(UUID id, UUID associatedEntityId, CommentAssociatedEntityType associatedEntityType,
                           SimpleUserResponse author, String body, LocalDate createdAt) {
        this.id = id;
        this.associatedEntityId = associatedEntityId;
        this.associatedEntityType = associatedEntityType;
        this.author = author;
        this.body = body;
        this.createdAt = createdAt;
    }

    public CommentResponse(Comment comment) {
        this.id = comment.getId().value();
        this.associatedEntityId = comment.getAssociatedEntityId().value();
        this.associatedEntityType = comment.getAssociatedEntityType();
        this.author = new SimpleUserResponse(comment.getAuthor());
        this.body = comment.getBody().value();
        this.createdAt = comment.getCreatedAt().value();
    }

    public UUID getId() {
        return id;
    }

    public UUID getAssociatedEntityId() {
        return associatedEntityId;
    }

    public CommentAssociatedEntityType getAssociatedEntityType() {
        return associatedEntityType;
    }

    public SimpleUserResponse getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
