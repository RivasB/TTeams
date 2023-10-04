package cloud.tteams.station.chargingpoint.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

public class FindAllChargingPointQuery implements IQuery {
    private final Pageable pageable;

    public FindAllChargingPointQuery(Pageable pageable) {
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
