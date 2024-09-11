package cloud.tteams.identity.user.application.command.register.data;

public record RegisterUserRequest(String firstName, String lastName, String email, String phone, String password) {

}
