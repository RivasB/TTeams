package cloud.tteams.log.log.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public class GetAllLogQuery implements IQuery {

    private final Map<String, Object> filters;
    private final Pageable pageable;

    public GetAllLogQuery(Map<String, Object> filters, Pageable pageable) {
        this.filters = filters;
        this.pageable = pageable;
    }

    public Map<String, Object> filters() {
        return filters;
    }

    public Pageable pageable() {
        return pageable;
    }
}
