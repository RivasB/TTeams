package cloud.tteams.project.project.domain.rules;

import cloud.tteams.project.project.domain.valueobject.ProjectId;
import cloud.tteams.project.project.domain.valueobject.ProjectName;
import cloud.tteams.project.project.infrastructure.adapter.query.IProjectQueryJPARepository;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProjectNameMustBeUnique extends BusinessRule {

    private final IProjectQueryJPARepository jpaRepository;
    private final ProjectName name;
    private final ProjectId id;

    public ProjectNameMustBeUnique(IProjectQueryJPARepository jpaRepository, ProjectName name, ProjectId id) {
        super("The project name must be unique!");
        this.jpaRepository = jpaRepository;
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean isBroken() {
        return jpaRepository.existsByNameAndIdNot(name.value(), id.value());
    }
}
