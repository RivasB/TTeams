package ec.gob.registrocivil.identity.geographiclocation.domain.rules;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

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
