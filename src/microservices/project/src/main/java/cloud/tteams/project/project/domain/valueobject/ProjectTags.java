package cloud.tteams.project.project.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.CollectionValueObject;

import java.util.Collection;

public class ProjectTags extends CollectionValueObject<String> {
    public ProjectTags(Collection<String> value) {
        super(value);
    }
}
