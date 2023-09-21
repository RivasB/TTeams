package cloud.tteams.identity.validation_mesh.application.query.find;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.identity.validation_mesh.domain.Validation;
import cloud.tteams.identity.validation_mesh.domain.ValidationDescription;
import cloud.tteams.identity.validation_mesh.domain.service.IValidationService;

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
