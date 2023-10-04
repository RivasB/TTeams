package cloud.tteams.station.station.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

public class FindAllStationQuery implements IQuery {

    private final Pageable pageable;

    public FindAllStationQuery(Pageable pageable) {
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
