package cloud.tteams.identity.user.infrastructure.port;

import cloud.tteams.identity.user.application.UserResponse;
import cloud.tteams.identity.user.application.command.changepassword.UserChangePasswordCommand;
import cloud.tteams.identity.user.application.command.changepassword.UserChangePasswordMessage;
import cloud.tteams.identity.user.application.command.changepassword.UserChangePasswordRequest;
import cloud.tteams.identity.user.application.command.register.data.RegisterUserCommand;
import cloud.tteams.identity.user.application.command.register.data.RegisterUserMessage;
import cloud.tteams.identity.user.application.command.register.data.RegisterUserRequest;
import cloud.tteams.identity.user.application.command.register.validate.ValidateUserCodeCommand;
import cloud.tteams.identity.user.application.command.register.validate.ValidateUserCodeMessage;
import cloud.tteams.identity.user.application.command.register.validate.ValidateUserCodeRequest;
import cloud.tteams.identity.user.application.command.update.UpdateUserCommand;
import cloud.tteams.identity.user.application.command.update.UpdateUserMessage;
import cloud.tteams.identity.user.application.command.update.UpdateUserRequest;
import cloud.tteams.identity.user.application.query.getbyemail.FindUserByEmailQuery;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "User", description = "The User API. Contains all the operations that can be performed on a user.")
public class UserController {

    private final IMediator mediator;

    public UserController(IMediator mediator) {
        this.mediator = mediator;
    }

    // User registration process (STEP 1)
    @PostMapping("/register")
    public ResponseEntity<ApiResponse2xx<RegisterUserMessage>> registerUserSendData(
            @RequestBody @Valid RegisterUserRequest request) {
        RegisterUserCommand command = RegisterUserCommand.fromRequest(request);
        RegisterUserMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    // User registration process (STEP 2)
    @PostMapping("/register/code")
    public ResponseEntity<ApiResponse2xx<ValidateUserCodeMessage>> registerUserCheckCode(
            @RequestBody ValidateUserCodeRequest request) {
        ValidateUserCodeCommand command = ValidateUserCodeCommand.fromRequest(request);
        ValidateUserCodeMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @PostMapping("/change/password")
    public ResponseEntity<ApiResponse2xx<UserChangePasswordMessage>> changePassword(
            @RequestBody UserChangePasswordRequest request) {
        UserChangePasswordCommand command = UserChangePasswordCommand.fromRequest(request);
        UserChangePasswordMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse2xx<UserResponse>> retrieveLoggedUser(
            @RequestHeader("Authorization") String jwToken) {
        FindUserByEmailQuery query = new FindUserByEmailQuery(jwToken);
        UserResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateUserMessage>> updateUser(
            @RequestBody UpdateUserRequest request) {
        UpdateUserCommand command = UpdateUserCommand.fromRequest(request);
        UpdateUserMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

}
