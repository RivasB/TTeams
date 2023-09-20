package ec.gob.registrocivil.identity.aplication.application.query.getall;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindApplicationWithFilterQuery implements IQuery {

    private Pageable pageable;

    private String filter;

    public FindApplicationWithFilterQuery(Pageable pageable, String filter) {
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
