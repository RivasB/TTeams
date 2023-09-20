package ec.gob.registrocivil.identity.aplication.application.command.update;

import java.util.Collection;
import java.util.UUID;

import ec.gob.registrocivil.identity.aplication.domain.AplicationState;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class UpdateAplicationCommand implements ICommand {

    private UUID id;

    private String name;

    private String description;

    private AplicationState state;

    private Collection<UUID> access;

    public UpdateAplicationCommand(String name, String description, AplicationState state, Collection<UUID> access) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.state = state;
        this.access = access;
    }

    public static UpdateAplicationCommand fromRequest(UpdateAplicationRequest request) {

        return new UpdateAplicationCommand(
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
        return new UpdateAplicationMessage(id);
    }

}
