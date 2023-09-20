package ec.gob.registrocivil.identity.geographiclocation.application.command.update;

import java.util.UUID;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class UpdateGeographicLocationCommand implements ICommand {

    private UUID id;

    private String name;

    private GeographicLocationType type;

    private UUID parent;

    public UpdateGeographicLocationCommand() {
    }

    public UpdateGeographicLocationCommand(UUID id, String name, GeographicLocationType type, UUID parent) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public static UpdateGeographicLocationCommand fromRequest(UpdateGeographicLocationRequest request) {

        return new UpdateGeographicLocationCommand(
                request.getId(),
                request.getName(),
                request.getType(),
                request.getParent());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GeographicLocationType getType() {
        return type;
    }

    public UUID getParent() {
        return parent;
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateGeographicLocationMessage(id);
    }
}
