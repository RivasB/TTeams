package ec.gob.registrocivil.identity.user.application.query.validatenui;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class ValidateCitizenNuiQuery implements IQuery {

    private String nui;

    public ValidateCitizenNuiQuery(String nui) {
        this.nui = nui;
    }

    public static ValidateCitizenNuiQuery fromRequest(ValidateCitizenNuiRequest request) {

        return new ValidateCitizenNuiQuery(request.getNui());
    }

    public String getNui() {
        return nui;
    }

}
