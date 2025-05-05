package cloud.tteams.notification.notification.application.query;

import cloud.tteams.notification.notification.domain.Notification;
import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationResponse implements IResponse {
    private final UUID id;
    private final UUID dataId;
    private final UUID recipientUuid;
    private final String service;
    private final String message;
    private final LocalDateTime createdAt;
    private final NotificationPriority priority;
    private final NotificationStatus status;


    public NotificationResponse(Notification notification) {
        this.id = notification.getId().value();
        this.dataId = notification.getDataId().value();
        this.recipientUuid = notification.getRecipient().value();
        this.service = notification.getService().value();
        this.message = notification.getMessage().value();
        this.createdAt = notification.getCreatedAt().value();
        this.priority = notification.getPriority();
        this.status = notification.getStatus();
    }

    public UUID getId() {
        return id;
    }

    public UUID getDataId() {
        return dataId;
    }

    public UUID getRecipientUuid() {
        return recipientUuid;
    }

    public String getService() {
        return service;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public NotificationPriority getPriority() {
        return priority;
    }

    public NotificationStatus getStatus() {
        return status;
    }
}
