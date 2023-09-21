package cloud.tteams.identity.user.application.query.validatenuirelationship;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.share.middleware.nui.domain.service.IMiddlewareNuiServiceClient;
import cloud.tteams.share.middleware.nui.infrastructure.service.VerifyRelationshipResponse;
import org.springframework.stereotype.Component;

@Component
public class ValidateCitizenNuiRelationShipQueryHandler
        implements IQueryHandler<ValidateCitizenNuiRelationShipQuery, ValidateCitizenNuiRelationShipResponse> {

    private final IMiddlewareNuiServiceClient iCitizenService;

    public ValidateCitizenNuiRelationShipQueryHandler(IMiddlewareNuiServiceClient iCitizenService) {
        this.iCitizenService = iCitizenService;
    }

    @Override
    public ValidateCitizenNuiRelationShipResponse handle(ValidateCitizenNuiRelationShipQuery query) {

         VerifyRelationshipResponse relationShip = iCitizenService.verifyRelationship(query.getFirstNui(), query.getSecondNui(), query.getRelationship());
         return new ValidateCitizenNuiRelationShipResponse(relationShip);
    }

}
