package ec.gob.registrocivil.identity.aplication.application.query.getbyid;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.AplicationId;
import ec.gob.registrocivil.identity.aplication.domain.service.IAplicationService;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
