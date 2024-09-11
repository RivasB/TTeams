package cloud.tteams.identity.security.application.login;

import cloud.tteams.identity.security.application.JavaWebTokenResponse;
import cloud.tteams.identity.security.domain.service.ISecurityService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginQueryHandler implements IQueryHandler<LoginQuery, JavaWebTokenResponse> {

    private final ISecurityService service;

    public LoginQueryHandler(ISecurityService service) {
        this.service = service;
    }
    @Override
    public JavaWebTokenResponse handle(LoginQuery query) {
        return service.login(query.getEmail(), query.getPassword());
    }
}
