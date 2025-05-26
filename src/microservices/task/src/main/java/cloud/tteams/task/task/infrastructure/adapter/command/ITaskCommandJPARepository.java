package cloud.tteams.task.task.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.task.task.infrastructure.repository.hibernate.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskCommandJPARepository extends JpaRepository<TaskEntity, UUID> {

}
