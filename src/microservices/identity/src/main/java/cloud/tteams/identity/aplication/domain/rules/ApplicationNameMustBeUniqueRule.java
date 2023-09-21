package cloud.tteams.identity.aplication.domain.rules;

import cloud.tteams.identity.aplication.infrastructure.service.DomainAplicationService;
import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ApplicationNameMustBeUniqueRule extends BusinessRule {

    private DomainAplicationService aplicationService;

    private Aplication application;

    public ApplicationNameMustBeUniqueRule(DomainAplicationService aplicationService, Aplication application) {
        super(DomainErrorMessage.APPLICATION_NAME_UNIQUE, "Aplication name must be unique!");

        this.aplicationService = aplicationService;
        this.application = application;
    }

    @Override
    public boolean isBroken() {
        return null == application.getName()
                || aplicationService.countByIdIsNotAndName(application.getId(), application.getName()) > 0;
    }
}
