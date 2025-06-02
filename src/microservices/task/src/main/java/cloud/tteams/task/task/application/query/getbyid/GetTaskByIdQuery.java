package cloud.tteams.task.task.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class GetTaskByIdQuery implements IQuery {

    private final UUID id;

    public GetTaskByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
