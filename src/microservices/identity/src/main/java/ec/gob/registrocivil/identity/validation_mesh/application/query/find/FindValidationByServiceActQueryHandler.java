package ec.gob.registrocivil.identity.validation_mesh.application.query.find;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.service.IValidationService;

@Component
public class FindValidationByServiceActQueryHandler
        implements IQueryHandler<FindValidationByServiceActQuery, FindValidationByServiceActResponse> {

    private final IValidationService validationService;

    public FindValidationByServiceActQueryHandler(IValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public FindValidationByServiceActResponse handle(FindValidationByServiceActQuery query) {

        ValidationDescription description = new ValidationDescription(query.getCedulaCondition());
        ValidationId vId = validationService.findValidationWithConditions(description).getId();

        ValidationByService validationByService = validationService.findValidationByServiceWithConditions(vId,
                query.getType(), query.getStatus());

        return new FindValidationByServiceActResponse(validationByService);
    }

}
