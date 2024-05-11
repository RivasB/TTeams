package cloud.tteams.identity.security.application.login;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class LoginQuery implements IQuery {

    private final String identification;

    private final String password;

    public LoginQuery(LoginRequest request) {
        this.identification = request.getIdentification();
        this.password = request.getPassword();
    }

    public String getIdentification() {
        return identification;
    }

    public String getPassword() {
        return password;
    }
}
