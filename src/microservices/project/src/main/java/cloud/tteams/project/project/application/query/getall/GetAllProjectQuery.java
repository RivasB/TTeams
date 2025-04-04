package cloud.tteams.project.project.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.util.Map;

@Getter
public class GetAllProjectQuery implements IQuery {

    private final Map<String, Object> filters;
    private final Pageable pageable;

    public GetAllProjectQuery(Map<String, Object> filters, Pageable pageable) {
        this.filters = filters;
        this.pageable = pageable;
    }

}
