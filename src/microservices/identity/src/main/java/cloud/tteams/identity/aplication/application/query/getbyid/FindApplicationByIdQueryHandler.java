package cloud.tteams.identity.aplication.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.AplicationId;
import cloud.tteams.identity.aplication.domain.service.IAplicationService;
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
