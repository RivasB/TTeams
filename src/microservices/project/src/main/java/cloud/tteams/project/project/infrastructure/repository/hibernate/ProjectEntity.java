package cloud.tteams.project.project.infrastructure.repository.hibernate;
import cloud.tteams.project.project.domain.*;
import cloud.tteams.project.project.domain.valueobject.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "project")
@Where(clause = "deleted = false")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column
    private LocalDate estimatedEndDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status;

    @Enumerated(EnumType.STRING)
    private ProjectPriority priority;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tags")
    private List<String> tags;

    @Column
    private boolean deleted = false;

    public void setAsDeleted(){
        this.deleted = true;
    }

    public ProjectEntity(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project cannot be null");
        }
        this.id = Objects.requireNonNull(project.getId().value(), "Project ID cannot be null");
        this.name = Objects.requireNonNull(project.getName().value(), "Project name cannot be null");
        this.description = Objects.nonNull(project.getDescription()) ? project.getDescription().value() : "";
        this.startDate = Objects.requireNonNull(project.getStartDate().value(), "Project start date cannot be null");
        this.estimatedEndDate = project.getEstimatedEndDate() != null ? project.getEstimatedEndDate().value() : null;
        this.status = Objects.requireNonNull(project.getStatus(), "Project status cannot be null");
        this.priority = project.getPriority();
        this.tags = project.getTags() != null ? project.getTags().value().stream().toList() : List.of();
    }

    public Project toAggregate() {
        return new Project(
                new ProjectId(this.id),
                new ProjectName(this.name),
                new ProjectDescription(this.description),
                new ProjectStartDate(this.startDate),
                new ProjectEstimatedEndDate(this.estimatedEndDate),
                this.status,
                this.priority,
                new ProjectTags(this.tags)
        );
    }
}

