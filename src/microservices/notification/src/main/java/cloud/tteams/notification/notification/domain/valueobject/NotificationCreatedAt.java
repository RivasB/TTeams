package cloud.tteams.notification.notification.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.DateTimeValueObject;

import java.time.LocalDateTime;

public class NotificationCreatedAt extends DateTimeValueObject {
    public NotificationCreatedAt(LocalDateTime value) {
        super(value);
    }
}
