package cloud.tteams.identity.user.application.query.validatenui;

public class ValidateCitizenNuiRequest {

    private String nui;

    public ValidateCitizenNuiRequest() {
    }

    public ValidateCitizenNuiRequest(String nui) {
        this.nui = nui;
    }

    public String getNui() {
        return nui;
    }

}
