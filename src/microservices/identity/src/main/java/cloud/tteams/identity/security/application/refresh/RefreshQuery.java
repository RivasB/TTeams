package cloud.tteams.identity.security.application.refresh;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class RefreshQuery implements IQuery {

    private  final String jwtToken;

    public RefreshQuery(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

}
