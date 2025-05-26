package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.CollectionValueObject;

import java.util.Collection;

public class TaskTags extends CollectionValueObject<String> {
    public TaskTags(Collection<String> value) {
        super(value);
    }
}
