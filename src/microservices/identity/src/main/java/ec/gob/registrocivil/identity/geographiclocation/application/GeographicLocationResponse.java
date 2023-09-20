package ec.gob.registrocivil.identity.geographiclocation.application;

import java.util.UUID;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;

public class GeographicLocationResponse {

    private UUID id;

    private String name;

    private GeographicLocationType type;

    public GeographicLocationResponse() {
    }

    public GeographicLocationResponse(UUID id, String name, GeographicLocationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public GeographicLocationResponse(GeographicLocation location) {
        this.id = location.getId().getValue();
        this.name = location.getName().getValue();
        this.type = location.getType();
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

}
