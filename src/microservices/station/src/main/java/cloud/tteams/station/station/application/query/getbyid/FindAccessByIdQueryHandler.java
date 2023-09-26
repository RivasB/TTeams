package cloud.tteams.identity.access.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.domain.AccessId;
import cloud.tteams.identity.access.domain.service.IAccessService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindAccessByIdQueryHandler implements IQueryHandler<FindAccessByIdQuery, FindAccessByIdResponse> {

    private final IAccessService accessService;

    public FindAccessByIdQueryHandler(IAccessService accessService) {
        this.accessService = accessService;
    }

    @Override
    public FindAccessByIdResponse handle(FindAccessByIdQuery query) {

        AccessId id = new AccessId(query.getId());
        Access access = accessService.findById(id);

        return new FindAccessByIdResponse(access);
    }

}
