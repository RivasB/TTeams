package cloud.tteams.task.task.domain.valueobject;

import cloud.tteams.share.core.domain.valueobject.Identifier;

import java.util.UUID;

public class TaskReportingUser extends Identifier {
    public TaskReportingUser(UUID value) {
        super(value);
    }
}
