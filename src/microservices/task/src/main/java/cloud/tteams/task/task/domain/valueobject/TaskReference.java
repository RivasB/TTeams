package cloud.tteams.task.task.domain.valueobject;

public class TaskReference {

    private final TaskId id;
    private final TaskName name;

    public TaskReference(TaskId id, TaskName name) {
        this.id = id;
        this.name = name;
    }

    public TaskId getId() {
        return id;
    }

    public TaskName getName() {
        return name;
    }
}
