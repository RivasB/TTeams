package cloud.tteams.project_management.project.domain;

public class Project {
    private final ProjectId id;

    private final ProjectName name;

    private final ProjectDescription description;

    private final ProjectStartDate startDate;

    private final ProjectEstimatedEndDate estimatedEndDate;

    private final ProjectStatus status;

    private final ProjectPriority priority;

    private final ProjectTags tags;

    private final ProjectComments comments;

    private final ProjectChangeLog changeLog;

    private final ProjectAttachments attachments;

    public Project(ProjectId id, ProjectName name, ProjectDescription description, ProjectStartDate startDate,
                   ProjectEstimatedEndDate estimatedEndDate, ProjectStatus status, ProjectPriority priority,
                   ProjectTags tags, ProjectComments comments, ProjectChangeLog changeLog,
                   ProjectAttachments attachments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.estimatedEndDate = estimatedEndDate;
        this.status = status;
        this.priority = priority;
        this.tags = tags;
        this.comments = comments;
        this.changeLog = changeLog;
        this.attachments = attachments;
    }

    public ProjectId getId() {
        return id;
    }

    public ProjectName getName() {
        return name;
    }

    public ProjectDescription getDescription() {
        return description;
    }

    public ProjectStartDate getStartDate() {
        return startDate;
    }

    public ProjectEstimatedEndDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public ProjectPriority getPriority() {
        return priority;
    }

    public ProjectTags getTags() {
        return tags;
    }

    public ProjectComments getComments() {
        return comments;
    }

    public ProjectChangeLog getChangeLog() {
        return changeLog;
    }

    public ProjectAttachments getAttachments() {
        return attachments;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", startDate=" + startDate +
                ", estimatedEndDate=" + estimatedEndDate +
                ", status=" + status +
                ", priority=" + priority +
                ", tags=" + tags +
                ", comments=" + comments +
                ", changeLog=" + changeLog +
                ", attachments=" + attachments +
                '}';
    }

   //TODO: Agregar los siguientes atributos en sus propias entidades, tags, comments, changelog, attachment

}
