package cloud.tteams.share.comment.domain;

import cloud.tteams.share.user.domain.User;

public class Comment {
    private final CommentId id;

    private final CommentAssociatedEntityId associatedEntityId;

    private final CommentAssociatedEntityType associatedEntityType;

    private final User author;

    private final CommentTextBody body;

    private final CommentCreatedAt createdAt;


    public Comment(CommentId id, CommentAssociatedEntityId associatedEntityId,
                   CommentAssociatedEntityType associatedEntityType, User author, CommentTextBody body, CommentCreatedAt createdAt) {
        this.id = id;
        this.associatedEntityId = associatedEntityId;
        this.associatedEntityType = associatedEntityType;
        this.author = author;
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

    public User getAuthor() {
        return author;
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
                ", author=" + author +
                ", body=" + body +
                ", createdAt=" + createdAt +
                '}';
    }
}
