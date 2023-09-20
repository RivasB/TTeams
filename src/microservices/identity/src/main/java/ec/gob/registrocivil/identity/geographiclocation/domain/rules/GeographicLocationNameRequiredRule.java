package ec.gob.registrocivil.identity.geographiclocation.domain.rules;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class GeographicLocationNameRequiredRule extends BusinessRule {

    GeographicLocation location;

    public GeographicLocationNameRequiredRule(GeographicLocation location) {
        super(DomainErrorMessage.GEOGRAPHIC_LOCATION_NAME_REQUIRED, "Geographic Location name is required!");
        this.location = location;
    }

    @Override
    public boolean isBroken() {

        return location.getName() == null || location.getName().value().isBlank();
    }

}
