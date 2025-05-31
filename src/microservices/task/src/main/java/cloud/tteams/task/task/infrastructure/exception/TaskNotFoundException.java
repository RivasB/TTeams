package cloud.tteams.task.task.infrastructure.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException() {
        super("Requested task not found!");
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
