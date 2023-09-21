package cloud.tteams.identity.access.domain.rules;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.domain.service.IAccessService;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

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
