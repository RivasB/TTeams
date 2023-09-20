package ec.gob.registrocivil.identity.geographiclocation.domain.rules;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class GeographicLocationTypeRequiredRule extends BusinessRule {

    GeographicLocation location;

    public GeographicLocationTypeRequiredRule(GeographicLocation location) {
        super(DomainErrorMessage.GEOGRAPHIC_LOCATION_TYPE_REQUIRED, "Geographic Location type is required!");
        this.location = location;
    }

    @Override
    public boolean isBroken() {

        return location.getType() == null;
    }

}
