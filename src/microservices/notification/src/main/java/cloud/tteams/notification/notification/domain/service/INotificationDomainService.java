package cloud.tteams.notification.notification.domain.service;

import cloud.tteams.notification.notification.domain.Notification;
import cloud.tteams.notification.notification.domain.valueobject.NotificationId;
import cloud.tteams.notification.notification.domain.valueobject.NotificationRecipient;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INotificationDomainService {
    Page<Notification> findAllByRecipient(NotificationRecipient recipient, Pageable pageable);
    Notification findById(NotificationId id);
    void create(Notification notification);
    Notification setStatus(NotificationId id, NotificationStatus status);
    void delete(NotificationId id);
}
