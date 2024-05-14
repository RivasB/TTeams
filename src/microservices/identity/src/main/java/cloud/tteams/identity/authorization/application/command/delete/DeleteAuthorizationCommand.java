package cloud.tteams.identity.authorization.application.command.delete;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public class DeleteAuthorizationCommand implements ICommand {

    private final UUID id;

    public DeleteAuthorizationCommand(UUID id) {
        this.id = id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.DELETED.toString());
    }

    public UUID getId() {
        return id;
    }
}
