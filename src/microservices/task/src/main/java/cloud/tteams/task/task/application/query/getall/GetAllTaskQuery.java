package cloud.tteams.task.task.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public class GetAllTaskQuery implements IQuery {

    private final Map<String, Object> filters;
    private final Pageable pageable;

    public GetAllTaskQuery(Map<String, Object> filters, Pageable pageable) {
        this.filters = filters;
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public Map<String, Object> getFilters() {
        return filters;
    }
}
