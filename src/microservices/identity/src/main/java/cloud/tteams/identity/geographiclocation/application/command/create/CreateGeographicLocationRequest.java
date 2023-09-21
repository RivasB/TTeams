package cloud.tteams.identity.geographiclocation.application.command.create;

import java.util.UUID;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;

public class CreateGeographicLocationRequest {

    private String name;

    private GeographicLocationType type;

    private UUID parent;

    public CreateGeographicLocationRequest() {
    }

    public CreateGeographicLocationRequest(String name, GeographicLocationType type, UUID parent) {
        this.name = name;
        this.type = type;
        this.parent = parent;
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

}
