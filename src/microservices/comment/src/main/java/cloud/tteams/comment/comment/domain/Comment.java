package cloud.tteams.comment.comment.domain;

public class Comment {
    private final CommentId id;

    private final CommentAssociatedEntityId associatedEntityId;

    private final CommentAssociatedEntityType associatedEntityType;

    private final CommentTextBody body;

    private final CommentCreatedAt createdAt;


    public Comment(CommentId id, CommentAssociatedEntityId associatedEntityId,
                   CommentAssociatedEntityType associatedEntityType, CommentTextBody body, CommentCreatedAt createdAt) {
        this.id = id;
        this.associatedEntityId = associatedEntityId;
        this.associatedEntityType = associatedEntityType;
        this.body = body;
        this.createdAt = createdAt;
    }

    public CommentId getId() {
        return id;
    }

    public CommentAssociatedEntityId getAssociatedEntityId() {
        return associatedEntityId;
    }

    public CommentAssociatedEntityType getAssociatedEntityType() {
        return associatedEntityType;
    }

    public CommentTextBody getBody() {
        return body;
    }

    public CommentCreatedAt getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", associatedEntityId=" + associatedEntityId +
                ", associatedEntityType=" + associatedEntityType +
                ", body=" + body +
                ", createdAt=" + createdAt +
                '}';
    }
}
