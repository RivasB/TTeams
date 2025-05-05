package cloud.tteams.notification.notification.infrastructure.repository.hibernate;

import cloud.tteams.notification.notification.domain.Notification;
import cloud.tteams.notification.notification.domain.valueobject.*;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tteams_notification")
@Where(clause = "status != 'DELETED'")
public class NotificationEntity {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "data_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID dataId;

    @Column(name = "recipient_uuid", nullable = false, columnDefinition = "BINARY(16)")
    private UUID recipientUuid;

    @Column(name = "service", nullable = false)
    private String service;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private NotificationPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private NotificationStatus status;

    public NotificationEntity() {
    }

    public NotificationEntity(Notification notification) {
        this.id = notification.getId().getValue();
        this.dataId = notification.getDataId().getValue();
        this.recipientUuid = notification.getRecipient().getValue();
        this.service = notification.getService().getValue();
        this.message = notification.getMessage().getValue();
        this.createdAt = notification.getCreatedAt().getValue();
        this.priority = notification.getPriority();
        this.status = notification.getStatus();
    }

    public Notification toAggregate() {
        return new Notification(
            new NotificationId(this.id),
            new NotificationDataId(this.dataId),
            new NotificationRecipient(this.recipientUuid),
            new NotificationService(this.service),
            new NotificationMessageContent(this.message),
            new NotificationCreatedAt(this.createdAt),
            this.priority,
            this.status
        );
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}