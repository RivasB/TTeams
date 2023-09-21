package cloud.tteams.identity.user.application.query.validatenui;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.share.middleware.nui.domain.service.IMiddlewareNuiServiceClient;
import cloud.tteams.share.middleware.nui.infrastructure.service.Ciudadano;
import org.springframework.stereotype.Component;

@Component
public class ValidateCitizenNuiQueryHandler
        implements IQueryHandler<ValidateCitizenNuiQuery, ValidateCitizenNuiResponse> {

    private final IMiddlewareNuiServiceClient iCitizenService;

    public ValidateCitizenNuiQueryHandler(IMiddlewareNuiServiceClient iCitizenService) {
        this.iCitizenService = iCitizenService;
    }

    @Override
    public ValidateCitizenNuiResponse handle(ValidateCitizenNuiQuery query) {

         Ciudadano citizen = iCitizenService.getCitizenByNui(query.getNui());
         return new ValidateCitizenNuiResponse(citizen);
    }

}
