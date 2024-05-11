package cloud.tteams.identity.security.domain.service;

import cloud.tteams.identity.security.application.JavaWebTokenResponse;
import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;

public interface ISecurityService {
    JavaWebTokenResponse login(String identification, String password) throws UnauthorizedException;

    JavaWebTokenResponse validate(String token) throws UnauthorizedException;

    JavaWebTokenResponse refresh(String jwtToken);
}
