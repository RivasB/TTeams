package cloud.tteams.comment.comment.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class GetByIdCommentQuery implements IQuery {

    private final UUID id;

    public GetByIdCommentQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
