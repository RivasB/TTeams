package cloud.tteams.notification.notification.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class NotificationRecipient extends Identifier {
    public NotificationRecipient(UUID value) {
        super(value);
    }
}
