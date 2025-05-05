package cloud.tteams.notification.notification.domain;

import cloud.tteams.notification.notification.domain.valueobject.*;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;

public class Notification {

    private final NotificationId id;
    private final NotificationDataId dataId;
    private final NotificationRecipient recipient;
    private final NotificationService service;
    private final NotificationMessageContent message;
    private final NotificationCreatedAt createdAt;
    private final NotificationPriority priority;
    private final NotificationStatus status;

    public Notification(NotificationId id, NotificationDataId dataId, NotificationRecipient recipient,
                        NotificationService service, NotificationMessageContent message, NotificationCreatedAt createdAt,
                        NotificationPriority priority, NotificationStatus status) {
        this.id = id;
        this.dataId = dataId;
        this.recipient = recipient;
        this.service = service;
        this.message = message;
        this.createdAt = createdAt;
        this.priority = priority;
        this.status = status;
    }

    public Notification(NotificationMessage notificationMessage) {
        this.id = new NotificationId(notificationMessage.getId());
        this.dataId = new NotificationDataId(notificationMessage.getDataId());
        this.recipient = new NotificationRecipient(notificationMessage.getRecipientUuid());
        this.service = new NotificationService(notificationMessage.getService());
        this.message = new NotificationMessageContent(notificationMessage.getMessage());
        this.createdAt = new NotificationCreatedAt(notificationMessage.getCreatedAt());
        this.priority = notificationMessage.getPriority();
        this.status = notificationMessage.getStatus();
    }

    public NotificationId getId() {
        return id;
    }

    public NotificationDataId getDataId() {
        return dataId;
    }

    public NotificationRecipient getRecipient() {
        return recipient;
    }

    public NotificationService getService() {
        return service;
    }

    public NotificationMessageContent getMessage() {
        return message;
    }

    public NotificationCreatedAt getCreatedAt() {
        return createdAt;
    }

    public NotificationPriority getPriority() {
        return priority;
    }

    public NotificationStatus getStatus() {
        return status;
    }
}
