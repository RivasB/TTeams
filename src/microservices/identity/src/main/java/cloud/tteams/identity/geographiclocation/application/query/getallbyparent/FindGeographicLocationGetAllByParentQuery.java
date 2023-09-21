package cloud.tteams.identity.geographiclocation.application.query.getallbyparent;

import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import java.util.UUID;

public class FindGeographicLocationGetAllByParentQuery implements IQuery {

    private Pageable pageable;

    private UUID id;

    public FindGeographicLocationGetAllByParentQuery(Pageable pageable, UUID id) {
        this.pageable = pageable;
        this.id = id;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public UUID getId() {
        return id;
    }

}
