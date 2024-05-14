package cloud.tteams.identity.authorization.infrastructure.port;

import cloud.tteams.identity.authorization.application.AuthorizationResponse;
import cloud.tteams.identity.authorization.application.command.create.CreateAuthorizationCommand;
import cloud.tteams.identity.authorization.application.command.create.CreateAuthorizationRequest;
import cloud.tteams.identity.authorization.application.command.delete.DeleteAuthorizationCommand;
import cloud.tteams.identity.authorization.application.command.update.UpdateAuthorizationCommand;
import cloud.tteams.identity.authorization.application.command.update.UpdateAuthorizationRequest;
import cloud.tteams.identity.authorization.application.query.getall.GetAllAuthorizationQuery;
import cloud.tteams.identity.authorization.application.query.getbyid.GetByIdAuthorizationQuery;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.identity.organization.application.command.create.CreateOrganizationCommand;
import cloud.tteams.identity.organization.application.command.create.CreateOrganizationRequest;
import cloud.tteams.identity.organization.application.command.delete.DeleteOrganizationCommand;
import cloud.tteams.identity.organization.application.command.update.UpdateOrganizationCommand;
import cloud.tteams.identity.organization.application.command.update.UpdateOrganizationRequest;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/authorization")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Authorization", description = "The Authorization API. Contains all the command operations that can be " +
        "performed on a authorization.")
public class AuthorizationCommandController {

    private final IMediator mediator;

    public AuthorizationCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CommandMessage>> create(
            @RequestBody CreateAuthorizationRequest request) {
        CreateAuthorizationCommand createCommand = new CreateAuthorizationCommand(request);
        CommandMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<CommandMessage>> update(
            @RequestBody UpdateAuthorizationRequest request) {
        UpdateAuthorizationCommand command = new UpdateAuthorizationCommand(request);
        CommandMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> delete(@NotBlank @PathVariable("id") UUID id) {
        DeleteAuthorizationCommand command = new DeleteAuthorizationCommand(id);
        CommandMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
