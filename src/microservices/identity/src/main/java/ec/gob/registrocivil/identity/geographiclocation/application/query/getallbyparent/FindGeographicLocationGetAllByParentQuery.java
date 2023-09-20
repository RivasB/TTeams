package ec.gob.registrocivil.identity.geographiclocation.application.query.getallbyparent;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;
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
