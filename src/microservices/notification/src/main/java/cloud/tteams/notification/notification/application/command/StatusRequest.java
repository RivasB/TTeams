package cloud.tteams.notification.notification.application.command;

import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class StatusRequest {

    @NotNull(message = "Notification ID cannot be null")
    private final UUID id;
    @NotNull(message = "Notification Status cannot be null")
    private final NotificationStatus status;

    public StatusRequest(UUID id, NotificationStatus status) {
        this.id = id;
        this.status = status;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public UUID getId() {
        return id;
    }
}
