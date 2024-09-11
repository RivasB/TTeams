package cloud.tteams.identity.profile.application.command.create;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CreateProfileCommandHandler implements ICommandHandler<CreateProfileCommand> {

    private final IProfileService profileService;
    private final IOrganizationService organizationService;
    private final IAuthorizationService authorizationService;

    public CreateProfileCommandHandler(IProfileService profileService, IOrganizationService organizationService,
            IAuthorizationService authorizationService) {
        this.profileService = profileService;
        this.organizationService = organizationService;
        this.authorizationService = authorizationService;
    }

    @Override
    @Transactional
    public void handle(CreateProfileCommand command) {
        Organization organization = organizationService.findById(command.getOrganization());
        List<Authorization> authorizations = command.getAuthorizations()
                .stream().map(authorizationService::findById).collect(Collectors.toList());
        Profile profile = new Profile(command.getId(), command.getName(), command.getDescription(), organization,
                command.getState(), authorizations);
        profileService.create(profile);
    }

}
