package cloud.tteams.identity.user.application.command.register.data;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public final class RegisterUserCommand implements ICommand {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String password;

    public RegisterUserCommand(UUID id, String firstName, String lastName, String email, String phone,
                               String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public static RegisterUserCommand fromRequest(RegisterUserRequest request) {
        return new RegisterUserCommand(
                UUID.randomUUID(), request.firstName(), request.lastName(),
                request.email(), request.phone(), request.password());
    }

    @Override
    public ICommandMessage getMessage() {
        return new RegisterUserMessage(id);
    }

    public UUID id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public String password() {
        return password;
    }

}
