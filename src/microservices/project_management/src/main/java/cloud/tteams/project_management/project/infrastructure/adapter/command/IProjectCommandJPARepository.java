package cloud.tteams.project_management.project.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.project_management.project.infrastructure.repository.hibernate.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectCommandJPARepository extends JpaRepository<ProjectEntity, UUID> {

}
