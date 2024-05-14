package cloud.tteams.identity.authorization.application.command.update;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.domain.event.EventType;

import java.util.UUID;

public class UpdateAuthorizationCommand implements ICommand {
    private final UUID id;
    private final String name;
    private final String resource;
    private final AuthorizedAction action;
    private final State state;

    public UpdateAuthorizationCommand(UpdateAuthorizationRequest request) {
        this.id = request.getId();
        this.name = request.getName();
        this.resource = request.getResource();
        this.action = request.getAction();
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
