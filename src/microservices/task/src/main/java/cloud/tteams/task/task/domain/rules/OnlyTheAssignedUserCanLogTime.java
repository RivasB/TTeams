package cloud.tteams.task.task.domain.rules;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.task.task.domain.valueobject.TaskAssignedUser;

import java.util.UUID;

public class OnlyTheAssignedUserCanLogTime extends BusinessRule {

    private final TaskAssignedUser assignedUser;

    public OnlyTheAssignedUserCanLogTime(TaskAssignedUser assignedUser) {
        super("Only the assigned user can log time");
        this.assignedUser = assignedUser;
    }

    @Override
    public boolean isBroken() {
        try {
            UUID contextUserUUID = UserContext.getUserSession().getUserId();
            return !assignedUser.value().equals(contextUserUUID);
        }
        catch (Exception ignored) {
            return false;
        }
    }
}
