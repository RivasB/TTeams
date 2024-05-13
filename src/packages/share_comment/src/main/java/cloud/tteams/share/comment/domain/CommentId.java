package cloud.tteams.share.comment.domain;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class CommentId extends Identifier {
    public CommentId(UUID value) {
        super(value);
    }
}
