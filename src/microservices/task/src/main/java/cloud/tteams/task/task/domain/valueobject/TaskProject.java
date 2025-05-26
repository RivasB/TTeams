package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class TaskProject extends Identifier {
    public TaskProject(UUID value) {
        super(value);
    }
}
