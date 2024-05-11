package cloud.tteams.identity.security.infrastructure.service.utility;

import cloud.tteams.identity.security.domain.service.utility.IAuthenticationService;
import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationServiceImplementation implements IAuthenticationService {

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImplementation(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void authenticate(String identification, String password) throws UnauthorizedException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(identification, password));
        } catch (DisabledException e) {
            throw new UnauthorizedException("User disabled");
        } catch (Exception e) {
            throw new UnauthorizedException("Bad Credentials");
        }
    }
}
