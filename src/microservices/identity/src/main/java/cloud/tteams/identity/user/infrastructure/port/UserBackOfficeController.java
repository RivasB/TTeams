package cloud.tteams.identity.user.infrastructure.port;

import java.util.UUID;

import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.tteams.identity.security.infrastructure.service.utility.JavaWebTokenServiceImplementation;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.identity.user.application.command.create.CreateUserCommand;
import cloud.tteams.identity.user.application.command.create.CreateUserMessage;
import cloud.tteams.identity.user.application.command.create.CreateUserRequest;
import cloud.tteams.identity.user.application.command.delete.DeleteUserCommand;
import cloud.tteams.identity.user.application.command.delete.DeleteUserMessage;
import cloud.tteams.identity.user.application.command.update.UpdateUserCommand;
import cloud.tteams.identity.user.application.command.update.UpdateUserMessage;
import cloud.tteams.identity.user.application.command.update.UpdateUserRequest;
import cloud.tteams.identity.user.application.query.getall.FindUserWithFilterQuery;
import cloud.tteams.identity.user.application.query.getbyid.FindUserByIdQuery;
import cloud.tteams.identity.user.application.query.getbyid.FindUserByIdResponse;
import cloud.tteams.identity.user.application.query.getbyidentification.FindUserByIdentificationQuery;
import cloud.tteams.identity.user.application.query.getbyidentification.FindUserByIdentificationResponse;
import cloud.tteams.identity.user.domain.UserIdentification;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/backoffice/user")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "BackOffice User", description = "The User API. Contains all the operations that can be performed on a user.")
public class UserBackOfficeController {

    private final IMediator mediator;

    private final JavaWebTokenServiceImplementation jwTokenManager;

    public UserBackOfficeController(IMediator mediator, JavaWebTokenServiceImplementation jwTokenManager) {
        this.mediator = mediator;
        this.jwTokenManager = jwTokenManager;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateUserMessage>> createUser(
            @RequestBody CreateUserRequest request) {

        CreateUserCommand command = CreateUserCommand.fromRequest(request);
        CreateUserMessage response = mediator.send(command);

        return ResponseEntity.ok(new ApiResponse2xx<CreateUserMessage>(response, HttpStatus.CREATED));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<FindUserByIdResponse>> retrieveUser(@NotBlank @PathVariable UUID id) {

        FindUserByIdQuery query = new FindUserByIdQuery(id);
        FindUserByIdResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindUserByIdResponse>(response, HttpStatus.OK));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse2xx<FindUserByIdentificationResponse>> retrieveLogedUser(
            @RequestHeader("Authorization") String jwToken) {
        UserIdentification userIdentification = new UserIdentification(jwTokenManager.getIdentification(jwToken));

        FindUserByIdentificationQuery query = new FindUserByIdentificationQuery(userIdentification.getValue());
        FindUserByIdentificationResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindUserByIdentificationResponse>(response, HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAllUsers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "") String firstName,
            @RequestParam(defaultValue = "") String lastName,
            @RequestParam(defaultValue = "") String identification,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "CITIZEN") UserType type,
            @RequestParam(defaultValue = "ACTIVE") UserState state,
            @RequestParam(defaultValue = "firstName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {

        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindUserWithFilterQuery query = new FindUserWithFilterQuery(pageable, firstName, lastName, identification, email, type, state, filter);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteUserMessage>> deleteRole(@PathVariable("id") UUID id) {

        DeleteUserCommand command = new DeleteUserCommand(id);
        DeleteUserMessage response = mediator.send(command);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteUserMessage>(response, HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateUserMessage>> updateUser(
            @RequestBody UpdateUserRequest request) {

        UpdateUserCommand command = UpdateUserCommand.fromRequest(request);
        UpdateUserMessage response = mediator.send(command);

        return ResponseEntity.ok(new ApiResponse2xx<UpdateUserMessage>(response, HttpStatus.OK));
    }

}
