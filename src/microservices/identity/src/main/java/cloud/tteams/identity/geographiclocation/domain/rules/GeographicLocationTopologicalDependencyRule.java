package cloud.tteams.identity.geographiclocation.domain.rules;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class GeographicLocationTopologicalDependencyRule extends BusinessRule {

    GeographicLocation location;

    public GeographicLocationTopologicalDependencyRule(GeographicLocation location) {
        super(DomainErrorMessage.GEOGRAPHIC_LOCATION_TOPOLOGY_VIOLATION,
                "Geographic Location Topology Violation! Correct topology is: COUNTRY -> PROVINCE -> CANTON -> PARROQUIA");
        this.location = location;
    }

    @Override
    public boolean isBroken() {

        switch (location.getType()) {
            case COUNTRY:
                return location.getParent() != null;
            case PROVINCE:
                return location.getParent().getType() != GeographicLocationType.COUNTRY;
            case CANTON:
                return location.getParent().getType() != GeographicLocationType.PROVINCE;
            case PARROQUIA:
                return location.getParent().getType() != GeographicLocationType.CANTON;
            default:
                return false;
        }
    }

}
