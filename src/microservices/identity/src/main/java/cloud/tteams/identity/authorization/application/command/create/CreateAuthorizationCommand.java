package cloud.tteams.identity.authorization.application.command.create;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public class CreateAuthorizationCommand implements ICommand {
    private final UUID id;
    private final String name;
    private final String resource;
    private final AuthorizedAction action;
    private final State state;

    public CreateAuthorizationCommand(CreateAuthorizationRequest request) {
        this.id = UUID.randomUUID();
        this.name = request.name();
        this.resource = request.resource();
        this.action = request.action();
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

    public String getResource() {
        return resource;
    }

    public AuthorizedAction getAction() {
        return action;
    }

    public State getState() {
        return state;
    }
}
