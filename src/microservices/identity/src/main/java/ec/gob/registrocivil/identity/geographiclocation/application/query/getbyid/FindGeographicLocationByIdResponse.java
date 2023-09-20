package ec.gob.registrocivil.identity.geographiclocation.application.query.getbyid;

import java.util.UUID;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;

public class FindGeographicLocationByIdResponse implements IResponse {

    private UUID id;

    private String name;

    private GeographicLocationType type;

    public FindGeographicLocationByIdResponse(UUID id, String name, GeographicLocationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public FindGeographicLocationByIdResponse(GeographicLocation location) {
        this.id = location.getId().value();
        this.name = location.getName().value();
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
