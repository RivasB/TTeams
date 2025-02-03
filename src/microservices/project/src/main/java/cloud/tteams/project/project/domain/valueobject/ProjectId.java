package cloud.tteams.project.project.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class ProjectId extends Identifier {
    public ProjectId(UUID value) {
        super(value);
    }
}
