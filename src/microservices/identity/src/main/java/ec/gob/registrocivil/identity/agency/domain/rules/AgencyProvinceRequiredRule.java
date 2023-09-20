package ec.gob.registrocivil.identity.agency.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class AgencyProvinceRequiredRule extends BusinessRule {

    private String province;

    public AgencyProvinceRequiredRule(String province) {
        super(DomainErrorMessage.AGENCY_PROVINCE_REQUIRED, "Agency province is required!");
        this.province = province;
    }

    @Override
    public boolean isBroken() {
        return null == province || province.isBlank();
    }
}
