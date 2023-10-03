package cloud.tteams.station.location.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

public class FindAllLocationQuery implements IQuery {

    private final Pageable pageable;

    public FindAllLocationQuery(Pageable pageable) {
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
