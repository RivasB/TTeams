package cloud.tteams.identity.organization.application.query.getbyid;

import cloud.tteams.identity.organization.application.query.OrganizationResponse;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class GetOrganizationByIdQueryHandler implements IQueryHandler<GetOrganizationByIdQuery, OrganizationResponse> {

    private final IOrganizationService service;

    public GetOrganizationByIdQueryHandler(IOrganizationService service) {
        this.service = service;
    }

    @Override
    public OrganizationResponse handle(GetOrganizationByIdQuery query) {
        Organization organization = service.findById(query.id());
        return new OrganizationResponse(organization);
    }

}
