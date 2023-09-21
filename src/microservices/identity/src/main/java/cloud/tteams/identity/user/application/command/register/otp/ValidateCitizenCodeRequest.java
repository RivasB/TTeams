package cloud.tteams.identity.user.application.command.register.otp;

public class ValidateCitizenCodeRequest {

    private String code;

    private String password;

    public ValidateCitizenCodeRequest(String code, String password) {
        this.code = code;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public String getPassword() {
        return password;
    }

}
