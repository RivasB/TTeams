package cloud.tteams.identity.geographiclocation.application.query.getbytype;

import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;
import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindGeographicLocationByTypeQuery implements IQuery {

    private Pageable pageable;

    private String filter;

    private GeographicLocationType type;

    public FindGeographicLocationByTypeQuery(Pageable pageable, String filter, GeographicLocationType type) {
        this.pageable = pageable;
        this.filter = filter;
        this.type = type;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getFilter() {
        return filter;
    }

    public GeographicLocationType getType() {
        return type;
    }

}
