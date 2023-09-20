package ec.gob.registrocivil.identity.validation_mesh.application.query.find;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;
import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.service.IValidationService;

@Component
public class FindValidationQueryHandler
        implements IQueryHandler<FindValidationQuery, FindValidationResponse> {

    private final IValidationService validationService;

    public FindValidationQueryHandler(IValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public FindValidationResponse handle(FindValidationQuery query) {

        ValidationDescription description = new ValidationDescription(query.getCedulaCondition());
        Validation validation = validationService.findValidationWithConditions(description);

        return new FindValidationResponse(validation);
    }

}
