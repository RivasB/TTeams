package cloud.tteams.notification.notification.application.command.setstatus;

import cloud.tteams.notification.notification.application.command.StatusRequest;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;

import java.util.UUID;

public class SetStatusNotificationCommand implements ICommand {

    private final UUID id;
    private final NotificationStatus status;

    public SetStatusNotificationCommand(StatusRequest request) {
        this.id = request.getId();
        this.status = request.getStatus();
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(id, "STATUS_CHANGED");
    }

    public UUID getId() {
        return id;
    }

    public NotificationStatus getStatus() {
        return status;
    }
}
