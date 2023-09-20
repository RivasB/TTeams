package ec.gob.registrocivil.identity.user.application.query.validatenui;

import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;
import ec.gob.registrocivil.share.middleware.nui.infrastructure.service.Ciudadano;

public class ValidateCitizenNuiResponse implements IResponse {

    private Ciudadano citizen;

    public ValidateCitizenNuiResponse(Ciudadano citizen) {
        this.citizen = citizen;
    }

    public Ciudadano getCitizen() {
        return citizen;
    }

}
