package ec.gob.registrocivil.identity.validation_mesh.application.query.find;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.service.IValidationService;

@Component
public class FindValidationByServiceCertificateQueryHandler
        implements IQueryHandler<FindValidationByServiceCertificateQuery, FindValidationByServiceCertificateResponse> {

    private final IValidationService validationService;

    public FindValidationByServiceCertificateQueryHandler(IValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public FindValidationByServiceCertificateResponse handle(FindValidationByServiceCertificateQuery query) {

        ValidationDescription description = new ValidationDescription(query.getCedulaCondition());
        ValidationId vId = validationService.findValidationWithConditions(description).getId();

        ValidationByService validationByService = validationService.findValidationByServiceWithConditions(vId,
                query.getType(), query.getStatus());

        return new FindValidationByServiceCertificateResponse(
                validationByService.getId().value(),
                validationByService.getType(),
                validationByService.getStatus(),
                validationByService.getCanRequestBirth().value(),
                validationByService.getCanRequestMarriage().value(),
                validationByService.getCanRequestDeath().value(),
                validationByService.getCanRequestDeFactoUnion().value(),
                validationByService.getCanRequestIdentityAndCivilStatus().value());
    }

}
