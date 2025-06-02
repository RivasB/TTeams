package cloud.tteams.task.task.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.task.task.domain.valueobject.TaskSprint;

public class SprintMustExistAndNotBeClosed extends BusinessRule {

    private final TaskSprint sprint;

    public SprintMustExistAndNotBeClosed(TaskSprint sprint) {
        super("Sprint must exist and not be closed");
        this.sprint = sprint;
    }

    @Override
    public boolean isBroken() {
        //TODO: verificar que el Sprint exista y no este cerrado usando cache distribuida
        return false;
    }
}
