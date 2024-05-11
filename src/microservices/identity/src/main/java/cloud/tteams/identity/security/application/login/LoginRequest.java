package cloud.tteams.identity.security.application.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {

    @NotNull @NotBlank
    private String identification;

    @NotNull @NotBlank
    private String password;

    public String getIdentification() {
        return identification;
    }

    public String getPassword() {
        return password;
    }
}
