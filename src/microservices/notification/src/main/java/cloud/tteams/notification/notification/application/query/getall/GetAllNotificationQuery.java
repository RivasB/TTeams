package cloud.tteams.notification.notification.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class GetAllNotificationQuery implements IQuery {

    private final UUID recipient;
    private final Pageable pageable;

    public GetAllNotificationQuery(UUID recipient, Pageable pageable) {
        this.recipient = recipient;
        this.pageable = pageable;
    }

    public UUID getRecipient() {
        return recipient;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
