package cloud.tteams.project_management.project.infrastructure.adapter.query;


import cloud.tteams.project_management.project.domain.ProjectStatus;
import cloud.tteams.project_management.project.infrastructure.repository.hibernate.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface IProjectQueryJPARepository extends JpaRepository<ProjectEntity, UUID> {

}
