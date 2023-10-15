package cloud.tteams.project_management.project.infrastructure.repository.hibernate;
import cloud.tteams.project_management.project.domain.*;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tteams_project")
public class ProjectEntity {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "status")
    private ProjectStatus status;

    public ProjectEntity() {
    }

    public ProjectEntity(Project project) {
        this.id = project.getId().value();
        this.status = project.getStatus();
    }

    public Project toAggregate() {
        ProjectId id = new ProjectId(this.id);
        ProjectStatus status = this.status;
        return null;
    }

    public UUID getId() {
        return id;
    }
}
