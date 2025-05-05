package cloud.tteams.notification.notification.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class NotificationDataId extends Identifier {
    public NotificationDataId(UUID value) {
        super(value);
    }
}
