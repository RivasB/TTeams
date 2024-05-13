package cloud.tteams.identity.organization.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

public class DeleteOrganizationCommand implements ICommand {

    private final UUID id;

    public DeleteOrganizationCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(id, EventType.UPDATED.toString());
    }

}
