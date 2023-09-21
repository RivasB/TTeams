package cloud.tteams.identity.geographiclocation.application.command.update;

import java.util.UUID;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;

public class UpdateGeographicLocationRequest {

    private UUID id;

    private String name;

    private GeographicLocationType type;

    private UUID parent;

    public UpdateGeographicLocationRequest() {
    }

    public UpdateGeographicLocationRequest(UUID id, String name, GeographicLocationType type, UUID parent) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parent = parent;
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

}
