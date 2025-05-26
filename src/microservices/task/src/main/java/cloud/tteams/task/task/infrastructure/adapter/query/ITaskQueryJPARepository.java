package cloud.tteams.task.task.infrastructure.adapter.query;


import cloud.tteams.task.task.infrastructure.repository.hibernate.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITaskQueryJPARepository extends JpaRepository<TaskEntity, UUID> {

}
