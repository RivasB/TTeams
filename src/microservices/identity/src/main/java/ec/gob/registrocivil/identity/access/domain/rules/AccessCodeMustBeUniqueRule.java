package ec.gob.registrocivil.identity.access.domain.rules;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.identity.access.domain.service.IAccessService;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class AccessCodeMustBeUniqueRule extends BusinessRule {

    private IAccessService accessService;

    private Access access;

    public AccessCodeMustBeUniqueRule(IAccessService accessService, Access access) {
        super(DomainErrorMessage.ACCESS_CODE_UNIQUE, "Access code must be unique!");

        this.accessService = accessService;
        this.access = access;
    }

    @Override
    public boolean isBroken() {
        return null == access.getCode() || accessService.countByIdIsNotAndCode(access.getId(), access.getCode()) > 0;
    }
}
