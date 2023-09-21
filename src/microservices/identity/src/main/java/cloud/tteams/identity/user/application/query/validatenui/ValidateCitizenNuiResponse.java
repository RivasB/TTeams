package cloud.tteams.identity.user.application.query.validatenui;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.share.middleware.nui.infrastructure.service.Ciudadano;

public class ValidateCitizenNuiResponse implements IResponse {

    private Ciudadano citizen;

    public ValidateCitizenNuiResponse(Ciudadano citizen) {
        this.citizen = citizen;
    }

    public Ciudadano getCitizen() {
        return citizen;
    }

}
