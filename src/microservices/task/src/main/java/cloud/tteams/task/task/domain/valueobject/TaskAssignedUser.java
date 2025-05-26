package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class TaskAssignedUser extends Identifier {
    public TaskAssignedUser(UUID value) {
        super(value);
    }
}
