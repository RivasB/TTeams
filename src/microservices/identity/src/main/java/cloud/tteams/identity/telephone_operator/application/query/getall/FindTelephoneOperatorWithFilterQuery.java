package cloud.tteams.identity.telephone_operator.application.query.getall;

import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindTelephoneOperatorWithFilterQuery implements IQuery {

    private Pageable pageable;

    private String filter;

    public FindTelephoneOperatorWithFilterQuery(Pageable pageable, String filter) {
        this.pageable = pageable;
        this.filter = filter;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getFilter() {
        return filter;
    }

}
