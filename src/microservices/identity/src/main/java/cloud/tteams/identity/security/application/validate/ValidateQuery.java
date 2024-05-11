package cloud.tteams.identity.security.application.validate;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class ValidateQuery implements IQuery {

    private  final String jwtToken;

    public ValidateQuery(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
