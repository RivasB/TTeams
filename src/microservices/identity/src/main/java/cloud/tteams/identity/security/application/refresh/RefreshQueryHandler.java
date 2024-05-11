package cloud.tteams.identity.security.application.refresh;

import cloud.tteams.identity.security.application.JavaWebTokenResponse;
import cloud.tteams.identity.security.domain.service.ISecurityService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;

public class RefreshQueryHandler implements IQueryHandler<RefreshQuery, JavaWebTokenResponse> {

    private final ISecurityService service;

    public RefreshQueryHandler(ISecurityService service) {
        this.service = service;
    }

    @Override
    public JavaWebTokenResponse handle(RefreshQuery query) throws UnauthorizedException {
        return service.refresh(query.getJwtToken());
    }
}
