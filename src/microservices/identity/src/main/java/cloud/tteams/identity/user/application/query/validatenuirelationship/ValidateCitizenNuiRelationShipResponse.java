package cloud.tteams.identity.user.application.query.validatenuirelationship;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.share.middleware.nui.infrastructure.service.VerifyRelationshipResponse;

public class ValidateCitizenNuiRelationShipResponse implements IResponse {

   private VerifyRelationshipResponse response;

    public ValidateCitizenNuiRelationShipResponse(VerifyRelationshipResponse response) {
        this.response = response;
    }

    public VerifyRelationshipResponse getResponse() {
        return response;
    }
}
