package cloud.tteams.project.project.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GetByIdProjectQuery implements IQuery {

    private final UUID id;

    public GetByIdProjectQuery(UUID id) {
        this.id = id;
    }
}
