package cloud.tteams.notification.notification.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class GetByIdNotificationQuery implements IQuery {

    private final UUID id;

    public GetByIdNotificationQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
