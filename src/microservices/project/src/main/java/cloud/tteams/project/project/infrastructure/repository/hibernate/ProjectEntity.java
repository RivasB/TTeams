package cloud.tteams.project.project.infrastructure.repository.hibernate;
import cloud.tteams.project.project.domain.*;
import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.comment.infrastructure.repository.hibernate.CommentEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private String tags;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;

    @ElementCollection
    @CollectionTable(name = "project_changelog", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "changeLog")
    private List<String> changeLog;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public ProjectPriority getPriority() {
        return priority;
    }

    public String getTags() {
        return tags;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public List<String> getChangeLog() {
        return changeLog;
    }
}

