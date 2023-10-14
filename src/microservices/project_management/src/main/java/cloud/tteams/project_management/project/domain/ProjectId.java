package cloud.tteams.project_management.project.domain;

import cloud.tteams.share.core.domain.Identifier;

import java.util.UUID;

public class ProjectId extends Identifier {
    public ProjectId(UUID value) {
        super(value);
    }
}
