package cloud.tteams.identity.geographiclocation.application.query.getall;

import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindGeographicLocationWithFilterQuery implements IQuery {

    private Pageable pageable;

    private String filter;

    public FindGeographicLocationWithFilterQuery(Pageable pageable, String filter) {
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
