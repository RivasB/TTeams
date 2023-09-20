package ec.gob.registrocivil.identity.user.infrastructure.service;

import ec.gob.registrocivil.identity.user.domain.rules.InvalidNUIFormatRule;
import ec.gob.registrocivil.identity.user.domain.service.ICitizenService;
import ec.gob.registrocivil.share.core.domain.RulesChecker;
import ec.gob.registrocivil.share.middleware.nui.domain.service.IMiddlewareNuiServiceClient;
import ec.gob.registrocivil.share.middleware.nui.infrastructure.service.Ciudadano;

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
