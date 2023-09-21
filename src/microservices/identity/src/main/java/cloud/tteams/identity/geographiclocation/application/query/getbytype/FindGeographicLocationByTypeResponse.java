package cloud.tteams.identity.geographiclocation.application.query.getbytype;

import java.util.UUID;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class FindGeographicLocationByTypeResponse implements IResponse {

    private UUID id;

    private String name;

    private GeographicLocationType type;

    public FindGeographicLocationByTypeResponse(UUID id, String name, GeographicLocationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public FindGeographicLocationByTypeResponse(GeographicLocation location) {
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
