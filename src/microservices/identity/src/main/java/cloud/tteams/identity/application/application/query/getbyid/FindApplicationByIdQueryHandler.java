package cloud.tteams.identity.application.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.identity.application.domain.AplicationId;
import cloud.tteams.identity.application.domain.service.IAplicationService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindApplicationByIdQueryHandler
        implements IQueryHandler<FindApplicationByIdQuery, FindApplicationByIdResponse> {

    private final IAplicationService aplicationService;

    public FindApplicationByIdQueryHandler(IAplicationService aplicationService) {
        this.aplicationService = aplicationService;
    }

    @Override
    public FindApplicationByIdResponse handle(FindApplicationByIdQuery query) {

        AplicationId id = new AplicationId(query.getId());
        Aplication application = aplicationService.findById(id);

        return new FindApplicationByIdResponse(application);
    }

}
