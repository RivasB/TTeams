package cloud.tteams.identity.user.infrastructure.service;

import cloud.tteams.identity.user.domain.rules.InvalidNUIFormatRule;
import cloud.tteams.identity.user.domain.service.ICitizenService;
import cloud.tteams.share.core.domain.RulesChecker;
import cloud.tteams.share.middleware.nui.domain.service.IMiddlewareNuiServiceClient;
import cloud.tteams.share.middleware.nui.infrastructure.service.Ciudadano;

public class DomainCitizenService implements ICitizenService {

    private final IMiddlewareNuiServiceClient iCitizenService;

    public DomainCitizenService(IMiddlewareNuiServiceClient iCitizenService) {
        this.iCitizenService = iCitizenService;
    }

    @Override
    public Ciudadano getCitizenByNUI(String nui) {
        RulesChecker.checkRule(new InvalidNUIFormatRule(nui));

        return iCitizenService.getCitizenByNui(nui);
    }
}
