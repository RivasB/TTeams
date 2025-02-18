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
    public void authenticate(String email, String password) throws UnauthorizedException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new UnauthorizedException("¡El usuario está deshabilitado!");
        } catch (Exception e) {
            throw new UnauthorizedException("¡Credenciales no válidas! Verifica tu correo electrónico y tu contraseña.");
        }
    }
}
