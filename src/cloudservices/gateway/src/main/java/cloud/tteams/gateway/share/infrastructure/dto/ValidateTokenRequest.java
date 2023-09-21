package cloud.tteams.gateway.share.infrastructure.dto;

public class ValidateTokenRequest {

    private String jwtToken;

    public ValidateTokenRequest(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public ValidateTokenRequest() {
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
