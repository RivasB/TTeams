package cloud.tteams.share.core.domain.notification;

import java.util.UUID;
import java.time.LocalDateTime;

public class Notification {
    private final UUID id;
    private final UUID dataId;
    private final UUID recipientUuid;
    private final String service;
    private final String message;
    private final LocalDateTime createdAt;
    private final NotificationPriority priority;
    private final NotificationStatus status;

    public Notification(UUID id, UUID dataId, UUID recipientUuid, String service, String message, LocalDateTime createdAt, NotificationPriority priority, NotificationStatus status) {
        this.id = id;
        this.dataId = dataId;
        this.recipientUuid = recipientUuid;
        this.service = service;
        this.message = message;
        this.createdAt = createdAt;
        this.priority = priority;
        this.status = status;
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
