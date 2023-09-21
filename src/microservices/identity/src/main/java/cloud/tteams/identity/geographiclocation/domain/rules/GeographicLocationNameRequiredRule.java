package cloud.tteams.identity.geographiclocation.domain.rules;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

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
