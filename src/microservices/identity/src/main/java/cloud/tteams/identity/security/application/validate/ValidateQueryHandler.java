package cloud.tteams.identity.security.application.validate;

import cloud.tteams.identity.security.application.JavaWebTokenResponse;
import cloud.tteams.identity.security.domain.service.ISecurityService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;
import org.springframework.stereotype.Component;

@Component
public class ValidateQueryHandler implements IQueryHandler<ValidateQuery, JavaWebTokenResponse> {

    private final ISecurityService service;

    public ValidateQueryHandler(ISecurityService service) {
        this.service = service;
    }

    @Override
    public JavaWebTokenResponse handle(ValidateQuery query) throws UnauthorizedException {
        return service.validate(query.getJwtToken());
    }
}
