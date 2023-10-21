package cloud.tteams.comment.comment.domain;

import cloud.tteams.share.core.domain.Identifier;

import java.util.UUID;

public class CommentId extends Identifier {
    public CommentId(UUID value) {
        super(value);
    }
}
