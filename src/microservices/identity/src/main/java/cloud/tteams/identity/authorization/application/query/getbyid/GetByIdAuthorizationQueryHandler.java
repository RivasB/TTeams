package cloud.tteams.identity.authorization.application.query.getbyid;

import cloud.tteams.identity.authorization.application.AuthorizationResponse;
import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class GetByIdAuthorizationQueryHandler implements IQueryHandler<GetByIdAuthorizationQuery, AuthorizationResponse> {

    private final IAuthorizationService service;

    public GetByIdAuthorizationQueryHandler(IAuthorizationService service) {
        this.service = service;
    }


    @Override
    public AuthorizationResponse handle(GetByIdAuthorizationQuery query) throws UnauthorizedException {
        Authorization authorization = service.findById(query.getId());
        return new AuthorizationResponse(authorization);
    }
}
