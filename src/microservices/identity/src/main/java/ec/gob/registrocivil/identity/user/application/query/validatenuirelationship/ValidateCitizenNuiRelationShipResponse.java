package ec.gob.registrocivil.identity.user.application.query.validatenuirelationship;

import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;
import ec.gob.registrocivil.share.middleware.nui.infrastructure.service.VerifyRelationshipResponse;

public class ValidateCitizenNuiRelationShipResponse implements IResponse {

   private VerifyRelationshipResponse response;

    public ValidateCitizenNuiRelationShipResponse(VerifyRelationshipResponse response) {
        this.response = response;
    }

    public VerifyRelationshipResponse getResponse() {
        return response;
    }
}
