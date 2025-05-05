package cloud.tteams.notification.notification.application.command.delete;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class DeleteNotificationCommand implements ICommand {

    private final UUID id;

    public DeleteNotificationCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "DELETED");
    }
}
