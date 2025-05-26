package cloud.tteams.task.task.infrastructure.repository.hibernate;

    import cloud.tteams.task.task.domain.Task;
    import cloud.tteams.task.task.domain.valueobject.*;
    import jakarta.persistence.*;
    import org.hibernate.annotations.CreationTimestamp;

    import java.time.LocalDate;
    import java.util.List;
    import java.util.UUID;

    @Entity
    @Table(name = "tteams_task")
    public class TaskEntity {

        @Id
        @Column(name = "id", nullable = false)
        private UUID id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "description")
        private String description;

        @Column(name = "created_date", nullable = false)
        @CreationTimestamp
        private LocalDate createdDate;

        @Column(name = "start_date")
        private LocalDate startDate;

        @Column(name = "estimated_end_date")
        private LocalDate estimatedEndDate;

        @Column(name = "completion_date")
        private LocalDate completionDate;

        @Column(name = "logged_time")
        private Integer loggedTime;

        @Column(name = "project", nullable = false)
        private UUID project;

        @Column(name = "assigned_user")
        private UUID assignedUser;

        @Column(name = "reporting_user", nullable = false)
        private UUID reportingUser;

        @ManyToOne
        @JoinColumn(name = "parent_task_id")
        private TaskEntity parentTask;

        @ManyToOne
        @JoinColumn(name = "blocked_by_id")
        private TaskEntity blockedBy;

        @Column(name = "sprint")
        private UUID sprint;

        @Column(name = "effort")
        private Integer effort;

        @Enumerated(EnumType.STRING)
        @Column(name = "type", nullable = false)
        private TaskType type;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        private TaskStatus status;

        @Enumerated(EnumType.STRING)
        @Column(name = "priority", nullable = false)
        private TaskPriority priority;

        @ElementCollection
        @CollectionTable(name = "tteams_task_tags", joinColumns = @JoinColumn(name = "task_id"))
        @Column(name = "tag")
        private List<String> tags;

        protected TaskEntity() {
        }

        public TaskEntity(Task task, TaskEntity parentTask, TaskEntity blockedBy) {
            this.id = task.getId().value();
            this.name = task.getName().value();
            this.description = task.getDescription().value();
            this.createdDate = task.getCreatedDate().value();
            this.startDate = task.getStartDate().value();
            this.estimatedEndDate = task.getEstimatedEndDate().value();
            this.completionDate = task.getCompletionDate().value();
            this.loggedTime = task.getLoggedTime().value();
            this.project = task.getProject().value();
            this.assignedUser = task.getAssignedUser().value();
            this.reportingUser = task.getReportingUser().value();
            this.parentTask = parentTask;
            this.blockedBy = blockedBy;
            this.sprint = task.getSprint() != null ? task.getSprint().value() : null;
            this.effort = task.getEffort() != null ? task.getEffort().value() : null;
            this.type = task.getType();
            this.status = task.getStatus();
            this.priority = task.getPriority();
            this.tags = (List<String>) task.getTags().getValue();
        }

        public TaskEntity(Task task) {
            this.id = task.getId().value();
            this.name = task.getName().value();
            this.description = task.getDescription().value();
            this.createdDate = task.getCreatedDate().value();
            this.startDate = task.getStartDate().value();
            this.estimatedEndDate = task.getEstimatedEndDate().value();
            this.completionDate = task.getCompletionDate().value();
            this.loggedTime = task.getLoggedTime().value();
            this.project = task.getProject().value();
            this.assignedUser = task.getAssignedUser().value();
            this.reportingUser = task.getReportingUser().value();
            this.sprint = task.getSprint() != null ? task.getSprint().value() : null;
            this.effort = task.getEffort() != null ? task.getEffort().value() : null;
            this.type = task.getType();
            this.status = task.getStatus();
            this.priority = task.getPriority();
            this.tags = (List<String>) task.getTags().getValue();
        }

        public void update(Task task) {
                if (task.getName() != null) this.name = task.getName().value();
                if (task.getDescription() != null) this.description = task.getDescription().value();
                if (task.getStartDate() != null) this.startDate = task.getStartDate().value();
                if (task.getEstimatedEndDate() != null) this.estimatedEndDate = task.getEstimatedEndDate().value();
                if (task.getCompletionDate() != null) this.completionDate = task.getCompletionDate().value();
                if (task.getLoggedTime() != null) this.loggedTime = task.getLoggedTime().value();
                if (task.getProject() != null) this.project = task.getProject().value();
                if (task.getAssignedUser() != null) this.assignedUser = task.getAssignedUser().value();
                if (task.getReportingUser() != null) this.reportingUser = task.getReportingUser().value();
                if (task.getSprint() != null) this.sprint = task.getSprint().value();
                if (task.getEffort() != null) this.effort = task.getEffort().value();
                if (task.getType() != null) this.type = task.getType();
                if (task.getStatus() != null) this.status = task.getStatus();
                if (task.getPriority() != null) this.priority = task.getPriority();
                if (task.getTags() != null) this.tags = (List<String>) task.getTags().getValue();
            }

            public Task toAggregate() {
                TaskReference parentTask = this.parentTask != null ?
                        new TaskReference(
                                new TaskId(this.parentTask.id),
                                new TaskName(this.parentTask.name)
                        ) : null;
                TaskReference blockedBy = this.blockedBy != null ?
                        new TaskReference(
                                new TaskId(this.blockedBy.id),
                                new TaskName(this.blockedBy.name)
                        ) : null;
                return new Task(
                    new TaskId(this.id),
                    new TaskName(this.name),
                    this.description != null ? new TaskDescription(this.description) : null,
                    new TaskCreatedDate(this.createdDate),
                    this.startDate != null ? new TaskStartDate(this.startDate) : null,
                    this.estimatedEndDate != null ? new TaskEstimatedEndDate(this.estimatedEndDate) : null,
                    this.completionDate != null ? new TaskCompletionDate(this.completionDate) : null,
                    this.loggedTime != null ? new TaskLoggedTime(this.loggedTime) : null,
                    new TaskProject(this.project),
                    this.assignedUser != null ? new TaskAssignedUser(this.assignedUser) : null,
                    new TaskReportingUser(this.reportingUser),
                    parentTask,
                    blockedBy,
                    this.sprint != null ? new TaskSprint(this.sprint) : null,
                    this.effort != null ? new TaskEstimatedEffort(this.effort) : null,
                    this.type,
                    this.status,
                    this.priority,
                    new TaskTags(this.tags)
                );
            }

        public void changeStatus(TaskStatus newStatus) {
            if (!isValidStatusTransition(newStatus)) {
                throw new IllegalArgumentException("Invalid status transition from " + this.status + " to " + newStatus);
            }
            if (this.status.equals(TaskStatus.PENDING) && newStatus.equals(TaskStatus.IN_PROGRESS) ) {
                this.startDate = LocalDate.now();
            }
            if (this.status.equals(TaskStatus.IN_PROGRESS_QA) && newStatus.equals(TaskStatus.COMPLETED)) {
                this.completionDate = LocalDate.now();
            }
            this.status = newStatus;
        }

        public boolean isValidStatusTransition(TaskStatus newStatus) {
            if (this.status == TaskStatus.PENDING && newStatus == TaskStatus.IN_PROGRESS) return true;
            if (this.status == TaskStatus.IN_PROGRESS && newStatus == TaskStatus.BLOCKED) return true;
            if (this.status == TaskStatus.BLOCKED && newStatus == TaskStatus.IN_PROGRESS) return true;
            if (this.status == TaskStatus.IN_PROGRESS && newStatus == TaskStatus.READY_TO_QA) return true;
            if (this.status == TaskStatus.READY_TO_QA && newStatus == TaskStatus.IN_PROGRESS_QA) return true;
            if (this.status == TaskStatus.IN_PROGRESS_QA && newStatus == TaskStatus.COMPLETED) return true;
            return newStatus == TaskStatus.DELETED;
        }

        public void assignUser(UUID assignedUser) {
            if (assignedUser == null) {
                throw new IllegalArgumentException("Assigned user cannot be null");
            }
            this.assignedUser = assignedUser;
        }

        public void setOrChangeSprint(UUID sprint) {
            if (sprint == null) {
                throw new IllegalArgumentException("Sprint cannot be null");
            }
            this.sprint = sprint;
        }

        public void setEffort(Integer effort) {
            if (effort == null || effort < 0) {
                throw new IllegalArgumentException("Effort must be a non-negative integer");
            }
            this.effort = effort;
        }


    }