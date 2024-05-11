package cloud.tteams.identity.security.application;

import cloud.tteams.share.core.domain.bus.query.IResponse;

public class JavaWebTokenResponse implements IResponse {

    private final String jwtToken;

    private final long usefulLifeInMillis;

    public JavaWebTokenResponse(String jwtToken, long ttlMillis) {
        this.jwtToken = jwtToken;
        this.usefulLifeInMillis = ttlMillis;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public long getUsefulLifeInMillis() {
        return usefulLifeInMillis;
    }
}
