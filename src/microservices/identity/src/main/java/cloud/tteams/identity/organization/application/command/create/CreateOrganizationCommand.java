package cloud.tteams.identity.organization.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

public class CreateOrganizationCommand implements ICommand {

    private final UUID id;

    private final String name;

    private final String description;

    private final String contact;

    private final State state;

    public CreateOrganizationCommand(CreateOrganizationRequest request) {
        this.id = UUID.randomUUID();
        this.name = request.name();
        this.description = request.description();
        this.contact = request.description();
        this.state = State.ACTIVE;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, EventType.CREATED.toString());
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
