package cloud.tteams.identity.security.application.login;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class LoginQuery implements IQuery {

    private final String email;

    private final String password;

    public LoginQuery(LoginRequest request) {
        this.email = request.getEmail();
        this.password = request.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
