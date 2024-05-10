package cloud.tteams.share.comment.domain;

import cloud.tteams.share.core.domain.Identifier;

import java.util.UUID;

public class CommentAssociatedEntityId extends Identifier {
    public CommentAssociatedEntityId(UUID value) {
        super(value);
    }
}
