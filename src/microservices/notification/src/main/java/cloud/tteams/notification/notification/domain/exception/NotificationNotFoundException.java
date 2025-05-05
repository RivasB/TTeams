package cloud.tteams.notification.notification.domain.exception;

import cloud.tteams.share.core.domain.exception.DomainException;

public class NotificationNotFoundException extends DomainException {
    public NotificationNotFoundException() {
        super("Notification not found");
    }
}
