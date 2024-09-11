package cloud.tteams.identity.organization.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

public record DeleteOrganizationCommand(UUID id) implements ICommand {

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(id, EventType.UPDATED.toString());
    }

}
