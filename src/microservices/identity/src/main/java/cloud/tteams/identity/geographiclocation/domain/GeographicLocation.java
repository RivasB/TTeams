package cloud.tteams.identity.geographiclocation.domain;

public class GeographicLocation {

    private GeographicLocationId id;

    private GeographicLocationName name;

    private GeographicLocationType type;

    private GeographicLocation parent;

    public GeographicLocation(GeographicLocationId id, GeographicLocationName name, GeographicLocationType type,
            GeographicLocation parent) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public GeographicLocationId getId() {
        return id;
    }

    public GeographicLocationName getName() {
        return name;
    }

    public GeographicLocationType getType() {
        return type;
    }

    public GeographicLocation getParent() {
        return parent;
    }

}
