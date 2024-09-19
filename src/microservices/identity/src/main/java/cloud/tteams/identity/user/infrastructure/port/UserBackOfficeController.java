package cloud.tteams.identity.user.infrastructure.port;

import java.util.UUID;

import cloud.tteams.identity.user.application.UserResponse;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import cloud.tteams.identity.user.application.query.getbyemail.FindUserByEmailQuery;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/backoffice/user")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "BackOffice User", description = "The User API. Contains all the operations that can be performed on a user.")
public class UserBackOfficeController {

    private static final Logger log = LoggerFactory.getLogger(UserBackOfficeController.class);
    private final IMediator mediator;

    public UserBackOfficeController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateUserMessage>> createUser(
            @RequestBody CreateUserRequest request) {
        CreateUserCommand command = CreateUserCommand.fromRequest(request);
        try {
            CreateUserMessage response = mediator.send(command);
            return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<UserResponse>> retrieveUser(@NotBlank @PathVariable UUID id) {
        FindUserByIdQuery query = new FindUserByIdQuery(id);
        UserResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse2xx<UserResponse>> retrieveLoggedUser(
            @RequestHeader("Authorization") String jwToken) {
        FindUserByEmailQuery query = new FindUserByEmailQuery(jwToken);
        UserResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
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
