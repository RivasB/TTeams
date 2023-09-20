package ec.gob.registrocivil.identity.user.infrastructure.port;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.registrocivil.identity.security.domain.service.JwtTokenManager;
import ec.gob.registrocivil.share.core.application.ApiResponse2xx;
import ec.gob.registrocivil.share.core.infrastructure.bus.IMediator;
import ec.gob.registrocivil.identity.user.application.command.changepassword.UserChangePasswordCommand;
import ec.gob.registrocivil.identity.user.application.command.changepassword.UserChangePasswordMessage;
import ec.gob.registrocivil.identity.user.application.command.changepassword.UserChangePasswordRequest;
import ec.gob.registrocivil.identity.user.application.command.register.data.RegisterCitizenCommand;
import ec.gob.registrocivil.identity.user.application.command.register.data.RegisterCitizenMessage;
import ec.gob.registrocivil.identity.user.application.command.register.data.RegisterCitizenRequest;
import ec.gob.registrocivil.identity.user.application.command.register.otp.ValidateCitizenCodeCommand;
import ec.gob.registrocivil.identity.user.application.command.register.otp.ValidateCitizenCodeMessage;
import ec.gob.registrocivil.identity.user.application.command.register.otp.ValidateCitizenCodeRequest;
import ec.gob.registrocivil.identity.user.application.command.update.UpdateUserCommand;
import ec.gob.registrocivil.identity.user.application.command.update.UpdateUserMessage;
import ec.gob.registrocivil.identity.user.application.command.update.UpdateUserRequest;
import ec.gob.registrocivil.identity.user.application.query.getbyidentification.FindUserByIdentificationQuery;
import ec.gob.registrocivil.identity.user.application.query.getbyidentification.FindUserByIdentificationResponse;
import ec.gob.registrocivil.identity.user.application.query.validatenui.ValidateCitizenNuiQuery;
import ec.gob.registrocivil.identity.user.application.query.validatenui.ValidateCitizenNuiRequest;
import ec.gob.registrocivil.identity.user.application.query.validatenui.ValidateCitizenNuiResponse;
import ec.gob.registrocivil.identity.user.application.query.validatenuirelationship.ValidateCitizenNuiRelationShipQuery;
import ec.gob.registrocivil.identity.user.application.query.validatenuirelationship.ValidateCitizenNuiRelationShipRequest;
import ec.gob.registrocivil.identity.user.application.query.validatenuirelationship.ValidateCitizenNuiRelationShipResponse;
import ec.gob.registrocivil.identity.user.domain.UserIdentification;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

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

    // User registration process (STEP 1)
    @PostMapping("/validate/relationship")
    public ResponseEntity<ApiResponse2xx<ValidateCitizenNuiRelationShipResponse>> registerUserCheckRelaionShipByNui(
            @RequestBody ValidateCitizenNuiRelationShipRequest request) {

        ValidateCitizenNuiRelationShipQuery query = ValidateCitizenNuiRelationShipQuery.fromRequest(request);
        ValidateCitizenNuiRelationShipResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<ValidateCitizenNuiRelationShipResponse>(response, HttpStatus.OK));
    }

    // User registration process (STEP 1)
    @PostMapping("/validate/citizen")
    public ResponseEntity<ApiResponse2xx<ValidateCitizenNuiResponse>> registerUserCheckNui(
            @RequestBody ValidateCitizenNuiRequest request) {

        ValidateCitizenNuiQuery query = ValidateCitizenNuiQuery.fromRequest(request);
        ValidateCitizenNuiResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<ValidateCitizenNuiResponse>(response, HttpStatus.OK));
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
