package cloud.tteams.comment.comment.application;

import cloud.tteams.comment.comment.domain.*;

import java.time.LocalDate;
import java.util.UUID;

public class CommentResponse {
    private final UUID id;

    private final UUID associatedEntityId;

    private final CommentAssociatedEntityType associatedEntityType;

    private final String body;

    private final LocalDate createdAt;

    public CommentResponse(UUID id, UUID associatedEntityId, CommentAssociatedEntityType associatedEntityType,
                           String body, LocalDate createdAt) {
        this.id = id;
        this.associatedEntityId = associatedEntityId;
        this.associatedEntityType = associatedEntityType;
        this.body = body;
        this.createdAt = createdAt;
    }

    public CommentResponse(Comment comment) {
        this.id = comment.getId().value();
        this.associatedEntityId = comment.getAssociatedEntityId().value();
        this.associatedEntityType = comment.getAssociatedEntityType();
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

    public String getBody() {
        return body;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

}
