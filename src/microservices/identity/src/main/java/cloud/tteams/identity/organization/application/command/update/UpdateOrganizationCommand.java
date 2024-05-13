package cloud.tteams.identity.organization.application.command.update;

import java.util.UUID;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

public class UpdateOrganizationCommand implements ICommand {

    private final UUID id;

    private final String name;

    private final String description;

    private final String contact;

    private final State state;

    public UpdateOrganizationCommand(UpdateOrganizationRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.description = request.getDescription();
        this.contact = request.getContact();
        this.state = request.getState();
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.UPDATED.toString());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    public State getState() {
        return state;
    }
}
