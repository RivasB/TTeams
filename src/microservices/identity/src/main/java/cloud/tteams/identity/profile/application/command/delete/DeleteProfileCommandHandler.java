package cloud.tteams.identity.profile.application.command.delete;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.ProfileId;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class DeleteProfileCommandHandler implements ICommandHandler<DeleteProfileCommand> {

    private final IProfileService profileService;

    public DeleteProfileCommandHandler(IProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public void handle(DeleteProfileCommand command) {
        ProfileId id = new ProfileId(command.getId());

        profileService.delete(id);
    }

}
