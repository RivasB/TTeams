package cloud.tteams.identity.user.application.command.update;

import cloud.tteams.identity.user.domain.RegistrationTokenState;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public record UpdateUserCommand(UUID id, String firstName, String lastName, String identification, String email,
                                String password, UserType type, UserState state, UUID profile,
                                RegistrationTokenState registrationState, String phone) implements ICommand {


    public static UpdateUserCommand fromRequest(UpdateUserRequest request) {

        return new UpdateUserCommand(
                request.id(),
                request.firstName(),
                request.lastName(),
                request.identification(),
                request.email(),
                request.password(),
                request.type(),
                request.state(),
                request.profile(),
                RegistrationTokenState.VERIFICATION_ACCEPTED,
                request.phone());
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateUserMessage(id);
    }
}
