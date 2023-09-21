package cloud.tteams.identity.security.application.authenticate;

public class AuthenticateUserResponse {

    private final String jwtToken;

    private final long usefulLifeInMillis;

    public AuthenticateUserResponse(String jwtToken, long ttlMillis) {
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
