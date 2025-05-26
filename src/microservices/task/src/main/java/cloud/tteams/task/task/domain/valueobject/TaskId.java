package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class TaskId extends Identifier {
    public TaskId(UUID value) {
        super(value);
    }
}
