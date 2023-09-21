package cloud.tteams.identity.aplication.application.command.create;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.identity.aplication.domain.AplicationState;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateAplicationCommand implements ICommand {

    private UUID id;

    private String name;

    private String description;

    private AplicationState state;

    private Collection<UUID> access;

    public CreateAplicationCommand(String name, String description, AplicationState state,
            Collection<UUID> access) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.state = state;
        this.access = access;
    }

    public static CreateAplicationCommand fromRequest(CreateAplicationRequest request) {

        return new CreateAplicationCommand(
                request.getName(),
                request.getDescription(),
                request.getState(),
                request.getAccess());
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

    public AplicationState getState() {
        return state;
    }

    public Collection<UUID> getAccess() {
        return access;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateAplicationMessage(id);
    }

}
