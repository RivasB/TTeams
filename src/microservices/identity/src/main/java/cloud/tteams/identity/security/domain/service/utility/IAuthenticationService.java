package cloud.tteams.identity.security.domain.service.utility;

import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;

public interface IAuthenticationService {
    void authenticate(String email, String password) throws UnauthorizedException;
}
