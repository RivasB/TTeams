package ec.gob.registrocivil.identity.geographiclocation.application.command.create;

import java.util.UUID;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class CreateGeographicLocationCommand implements ICommand {

    private UUID id;

    private String name;

    private GeographicLocationType type;

    private UUID parent;

    public CreateGeographicLocationCommand(String name, GeographicLocationType type, UUID parent) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public static CreateGeographicLocationCommand fromRequest(CreateGeographicLocationRequest request) {

        return new CreateGeographicLocationCommand(request.getName(), request.getType(), request.getParent());
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
        return new CreateGeographicLocationMessage(id);
    }

}
