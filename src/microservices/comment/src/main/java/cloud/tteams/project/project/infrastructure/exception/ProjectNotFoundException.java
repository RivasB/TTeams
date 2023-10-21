package cloud.tteams.project.project.infrastructure.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException() {
        super("Requested project not found!");
    }

}
