package cloud.tteams.identity.security.infrastructure.service;

import cloud.tteams.identity.security.application.JavaWebTokenResponse;
import cloud.tteams.identity.security.domain.service.ISecurityService;
import cloud.tteams.identity.security.domain.service.utility.IAuthenticationService;
import cloud.tteams.identity.security.domain.service.utility.IJavaWebTokenService;
import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class SecurityServiceImplementation implements ISecurityService {

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    private final IAuthenticationService authenticationService;

    private final UserDetailsService userDetailsService;

    private final IJavaWebTokenService javaWebTokenService;

    public SecurityServiceImplementation(IAuthenticationService authenticationService, UserDetailsService userDetailsService, IJavaWebTokenService javaWebTokenService) {
        this.authenticationService = authenticationService;
        this.userDetailsService = userDetailsService;
        this.javaWebTokenService = javaWebTokenService;
    }

    @Override
    public JavaWebTokenResponse login(String identification, String password) throws UnauthorizedException {
        authenticationService.authenticate(identification, password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(identification);
        final String token = javaWebTokenService.create(userDetails);
        return new JavaWebTokenResponse(token, ttlMillis);
    }

    @Override
    public JavaWebTokenResponse validate(String token) throws UnauthorizedException {
        boolean isValid = javaWebTokenService.validateAuthToken(token);
        if (isValid){
            return new JavaWebTokenResponse(token, 0L);
        }
        else {
            throw new UnauthorizedException("Provided token is not valid");
        }
    }

    @Override
    public JavaWebTokenResponse refresh(String jwtToken) {
        final String refreshedToken = javaWebTokenService.refreshAuthToken(jwtToken);
        return new JavaWebTokenResponse(refreshedToken, ttlMillis);
    }
}
