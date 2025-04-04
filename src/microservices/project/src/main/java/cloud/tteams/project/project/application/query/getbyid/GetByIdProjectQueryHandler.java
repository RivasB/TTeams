package cloud.tteams.project.project.application.query.getbyid;

import cloud.tteams.project.project.application.query.ProjectResponse;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.service.IProjectDomainService;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class GetByIdProjectQueryHandler implements IQueryHandler<GetByIdProjectQuery, ProjectResponse> {

    private final IProjectDomainService projectDomainService;

    public GetByIdProjectQueryHandler(IProjectDomainService projectDomainService) {
        this.projectDomainService = projectDomainService;
    }

    @Override
    public ProjectResponse handle(GetByIdProjectQuery query) {
        ProjectId projectId = new ProjectId(query.getId());
        Project project = projectDomainService.findById(projectId);
        return new ProjectResponse(project);
    }

}
