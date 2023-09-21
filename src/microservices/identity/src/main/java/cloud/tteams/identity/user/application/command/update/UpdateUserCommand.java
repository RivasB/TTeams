package cloud.tteams.identity.user.application.command.update;

import cloud.tteams.identity.user.domain.RegistrationTokenState;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.Collection;
import java.util.UUID;

public class UpdateUserCommand implements ICommand {

    private UUID id;

    private String firstName;

    private String lastName;

    private String identification;

    private String email;

    private UserType type;

    private UserState state;

    private Collection<UUID> profile;

    private RegistrationTokenState registrationState;

    private String phone;

    private UUID operator;

    public UpdateUserCommand(UUID id, String firstName, String lastName, String identification, String email,
                             UserType type, UserState state, Collection<UUID> profile,
                             RegistrationTokenState registrationState, String phone, UUID operator) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.type = type;
        this.state = state;
        this.profile = profile;
        this.registrationState = registrationState;
        this.phone = phone;
        this.operator = operator;
    }

    public static UpdateUserCommand fromRequest(UpdateUserRequest request) {

        return new UpdateUserCommand(
                request.getId(),
                request.getFirstName(),
                request.getLastName(),
                request.getIdentification(),
                request.getEmail(),
                request.getType(),
                request.getState(),
                request.getProfile(),
                RegistrationTokenState.VERIFICATION_ACCEPTED,
                request.getPhone(),
                request.getOperator());
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public String getEmail() {
        return email;
    }

    public UserType getType() {
        return type;
    }

    public UserState getState() {
        return state;
    }

    public Collection<UUID> getProfile() {
        return profile;
    }


    public RegistrationTokenState getRegistrationState() {
        return registrationState;
    }

    public String getPhone() {
        return phone;
    }

    public UUID getOperator() {
        return operator;
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateUserMessage(id);
    }

}
