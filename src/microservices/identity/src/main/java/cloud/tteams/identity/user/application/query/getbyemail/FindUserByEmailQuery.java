package cloud.tteams.identity.user.application.query.getbyemail;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindUserByEmailQuery implements IQuery {

    private final String jwtToken;

    public FindUserByEmailQuery(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getEmail() {
        return jwtToken;
    }

}
