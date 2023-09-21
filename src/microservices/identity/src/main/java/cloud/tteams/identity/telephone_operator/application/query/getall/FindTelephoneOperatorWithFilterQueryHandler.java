package cloud.tteams.identity.telephone_operator.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;

@Component
public class FindTelephoneOperatorWithFilterQueryHandler
        implements IQueryHandler<FindTelephoneOperatorWithFilterQuery, MessagePaginatedResponse> {

    private final ITelephoneOperatorService telephoneOperatorService;

    public FindTelephoneOperatorWithFilterQueryHandler(ITelephoneOperatorService telephoneOperatorService) {
        this.telephoneOperatorService = telephoneOperatorService;
    }

    @Override
    public MessagePaginatedResponse handle(FindTelephoneOperatorWithFilterQuery query) {

        return telephoneOperatorService.getPaginatedTelephoneOperator(query.getPageable(), query.getFilter());
    }

}
