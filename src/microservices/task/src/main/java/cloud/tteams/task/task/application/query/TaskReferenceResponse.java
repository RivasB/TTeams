package cloud.tteams.task.task.application.query;

import cloud.tteams.task.task.domain.valueobject.TaskReference;

import java.util.UUID;

public class TaskReferenceResponse {

    private final UUID id;
    private final String name;

    public TaskReferenceResponse(TaskReference parentTask) {
        this.id = parentTask.getId().value();
        this.name = parentTask.getName().value();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
