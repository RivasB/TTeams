package ec.gob.registrocivil.identity.agency.domain.rules;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.infrastructure.service.DomainAgencyService;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class AgencyNameMustBeUniqueRule extends BusinessRule {

    private DomainAgencyService agencyService;

    private Agency agency;

    public AgencyNameMustBeUniqueRule(DomainAgencyService agencyService, Agency agency) {
        super(DomainErrorMessage.AGENCY_NAME_UNIQUE, "Agency name must be unique!");

        this.agencyService = agencyService;
        this.agency = agency;
    }

    @Override
    public boolean isBroken() {
        return null == agency.getName() || agencyService.countByIdIsNotAndName(agency.getId(), agency.getName()) > 0;
    }
}
