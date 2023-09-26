package cloud.tteams.identity.user.infrastructure.port;

import cloud.tteams.identity.security.domain.service.JwtTokenManager;
import cloud.tteams.identity.user.application.command.changepassword.UserChangePasswordCommand;
import cloud.tteams.identity.user.application.command.changepassword.UserChangePasswordMessage;
import cloud.tteams.identity.user.application.command.changepassword.UserChangePasswordRequest;
import cloud.tteams.identity.user.application.command.register.data.RegisterCitizenCommand;
import cloud.tteams.identity.user.application.command.register.data.RegisterCitizenMessage;
import cloud.tteams.identity.user.application.command.register.data.RegisterCitizenRequest;
import cloud.tteams.identity.user.application.command.register.otp.ValidateCitizenCodeCommand;
import cloud.tteams.identity.user.application.command.register.otp.ValidateCitizenCodeMessage;
import cloud.tteams.identity.user.application.command.register.otp.ValidateCitizenCodeRequest;
import cloud.tteams.identity.user.application.command.update.UpdateUserCommand;
import cloud.tteams.identity.user.application.command.update.UpdateUserMessage;
import cloud.tteams.identity.user.application.command.update.UpdateUserRequest;
import cloud.tteams.identity.user.application.query.getbyidentification.FindUserByIdentificationQuery;
import cloud.tteams.identity.user.application.query.getbyidentification.FindUserByIdentificationResponse;
import cloud.tteams.identity.user.domain.UserIdentification;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "User", description = "The User API. Contains all the operations that can be performed on a user.")
public class UserController {

    private final IMediator mediator;
    
    private final JwtTokenManager jwTokenManager;

    public UserController(IMediator mediator, JwtTokenManager jwTokenManager) {
        this.mediator = mediator;
        this.jwTokenManager = jwTokenManager;
    }

    // User registration process (STEP 2)
    @PostMapping("/register/data")
    public ResponseEntity<ApiResponse2xx<RegisterCitizenMessage>> registerUserSendData(
            @RequestBody RegisterCitizenRequest request) {

        RegisterCitizenCommand command = RegisterCitizenCommand.fromRequest(request);
        RegisterCitizenMessage response = mediator.send(command);

        return ResponseEntity.ok(new ApiResponse2xx<RegisterCitizenMessage>(response, HttpStatus.OK));
    }

    // User registration process (STEP 3)
    @PostMapping("/register/code")
    public ResponseEntity<ApiResponse2xx<ValidateCitizenCodeMessage>> registerUserCheckCode(
            @RequestBody ValidateCitizenCodeRequest request) {

        ValidateCitizenCodeCommand command = ValidateCitizenCodeCommand.fromRequest(request);
        ValidateCitizenCodeMessage response = mediator.send(command);

        return ResponseEntity.ok(new ApiResponse2xx<ValidateCitizenCodeMessage>(response, HttpStatus.OK));
    }

    @PostMapping("/change/password")
    public ResponseEntity<ApiResponse2xx<UserChangePasswordMessage>> changePassword(
            @RequestBody UserChangePasswordRequest request) {

        UserChangePasswordCommand command = UserChangePasswordCommand.fromRequest(request);
        UserChangePasswordMessage response = mediator.send(command);

        return ResponseEntity.ok(new ApiResponse2xx<UserChangePasswordMessage>(response, HttpStatus.OK));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse2xx<FindUserByIdentificationResponse>> retrieveLogedUser(
            @RequestHeader("Authorization") String jwToken) {
        UserIdentification userIdentification = new UserIdentification(jwTokenManager.getIdentification(jwToken));

        FindUserByIdentificationQuery query = new FindUserByIdentificationQuery(userIdentification.getValue());
        FindUserByIdentificationResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindUserByIdentificationResponse>(response, HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateUserMessage>> updateUser(
            @RequestBody UpdateUserRequest request) {

        UpdateUserCommand command = UpdateUserCommand.fromRequest(request);
        UpdateUserMessage response = mediator.send(command);

        return ResponseEntity.ok(new ApiResponse2xx<UpdateUserMessage>(response, HttpStatus.OK));
    }

}
