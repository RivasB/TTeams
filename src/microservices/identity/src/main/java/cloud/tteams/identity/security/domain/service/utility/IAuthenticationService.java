package cloud.tteams.identity.security.domain.service.utility;

import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface IAuthenticationService {
    void authenticate(String identification, String password) throws UnauthorizedException;
}
