package cloud.tteams.project_management.project.infrastructure.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException() {
        super("Requested project not found!");
    }

}
