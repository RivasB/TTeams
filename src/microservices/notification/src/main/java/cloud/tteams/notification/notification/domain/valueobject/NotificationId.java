package cloud.tteams.notification.notification.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class NotificationId extends Identifier {
    public NotificationId(UUID value) {
        super(value);
    }
}
