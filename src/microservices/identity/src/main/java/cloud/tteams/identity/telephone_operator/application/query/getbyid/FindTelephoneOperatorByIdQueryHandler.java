package cloud.tteams.identity.telephone_operator.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;

@Component
public class FindTelephoneOperatorByIdQueryHandler
        implements IQueryHandler<FindTelephoneOperatorByIdQuery, FindTelephoneOperatorByIdResponse> {

    private final ITelephoneOperatorService telephoneOperatorService;

    public FindTelephoneOperatorByIdQueryHandler(ITelephoneOperatorService telephoneOperatorService) {
        this.telephoneOperatorService = telephoneOperatorService;
    }

    @Override
    public FindTelephoneOperatorByIdResponse handle(FindTelephoneOperatorByIdQuery query) {

        TelephoneOperatorId id = new TelephoneOperatorId(query.getId());
        TelephoneOperator operator = telephoneOperatorService.findById(id);

        return new FindTelephoneOperatorByIdResponse(operator);
    }

}
