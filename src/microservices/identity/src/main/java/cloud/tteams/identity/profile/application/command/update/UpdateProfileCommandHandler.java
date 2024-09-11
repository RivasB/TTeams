package cloud.tteams.identity.profile.application.command.update;

import java.util.List;
import java.util.stream.Collectors;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class UpdateProfileCommandHandler implements ICommandHandler<UpdateProfileCommand> {

    private final IProfileService profileService;
    private final IOrganizationService organizationService;
    private final IAuthorizationService authorizationService;

    public UpdateProfileCommandHandler(IProfileService profileService, IOrganizationService organizationService,
            IAuthorizationService authorizationService) {
        this.profileService = profileService;
        this.organizationService = organizationService;
        this.authorizationService = authorizationService;
    }

    @Override
    public void handle(UpdateProfileCommand command) {
        Organization organization = organizationService.findById(command.organization());
        List<Authorization> authorizations = command.authorizations()
                .stream().map(authorizationService::findById).collect(Collectors.toList());
        Profile profile = new Profile(command.id(), command.name(), command.description(), organization,
                command.state(), authorizations);
        profileService.update(profile);
    }

}
