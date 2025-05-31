package cloud.tteams.task.task.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.task.task.domain.valueobject.TaskAssignedUser;
import cloud.tteams.task.task.domain.valueobject.TaskProject;

public class AssignedUserMustBelongToTaskProject extends BusinessRule {

    private final TaskProject taskProject;
    private final TaskAssignedUser assignedUser;

    public AssignedUserMustBelongToTaskProject(TaskProject taskProject, TaskAssignedUser assignedUser) {
        super(String.format("User with ID: %s not belongs to Task's Project", assignedUser.getValue()));
        this.taskProject = taskProject;
        this.assignedUser = assignedUser;
    }

    @Override
    public boolean isBroken() {
        //TODO: verificar con el servicio de cache distribuida si el user pertenece al proyecto
        return false;
    }
}
