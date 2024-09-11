package cloud.tteams.identity.authorization.application.command.delete;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public record DeleteAuthorizationCommand(UUID id) implements ICommand {

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.DELETED.toString());
    }
}
