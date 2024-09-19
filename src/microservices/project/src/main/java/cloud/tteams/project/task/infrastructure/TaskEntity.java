package cloud.tteams.project.task.infrastructure;

import cloud.tteams.project.task.domain.TaskPriority;
import cloud.tteams.project.task.domain.TaskStatus;
import cloud.tteams.share.comment.infrastructure.repository.hibernate.CommentEntity;
import cloud.tteams.share.user.infrastructure.repository.hibernate.UserDto;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tteams_tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime dueDate;

    @Column
    private LocalDateTime completedDate;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private UserDto assignee;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private UserDto reporter;

    private String labels;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkLogEntity> workLogs;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public UserDto getAssignee() {
        return assignee;
    }

    public UserDto getReporter() {
        return reporter;
    }

    public String getLabels() {
        return labels;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public List<WorkLogEntity> getWorkLogs() {
        return workLogs;
    }
}
