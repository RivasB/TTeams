package cloud.tteams.project.task.infrastructure;

import cloud.tteams.share.user.infrastructure.repository.hibernate.UserDto;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tteams_task_work_logs")
public class WorkLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDto user;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(length = 1000)
    private String description;

    public Long getId() {
        return id;
    }

    public TaskEntity getTask() {
        return task;
    }

    public UserDto getUser() {
        return user;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }
}

