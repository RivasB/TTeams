package cloud.tteams.project.project.infrastructure.adapter.query;


import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProjectQueryJPARepository extends JpaRepository<ProjectEntity, UUID> {
    Boolean existByNameAndIdNot(String value, UUID value1);
}
