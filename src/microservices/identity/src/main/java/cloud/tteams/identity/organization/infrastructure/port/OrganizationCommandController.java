package cloud.tteams.identity.organization.infrastructure.port;

import cloud.tteams.identity.organization.application.command.create.CreateOrganizationCommand;
import cloud.tteams.identity.organization.application.command.create.CreateOrganizationRequest;
import cloud.tteams.identity.organization.application.command.delete.DeleteOrganizationCommand;
import cloud.tteams.identity.organization.application.command.update.UpdateOrganizationCommand;
import cloud.tteams.identity.organization.application.command.update.UpdateOrganizationRequest;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.CommandMessage;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/agency")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Organization", description = "The Organization Command API. Contains all the command operations that can" +
        " be performed on a organization.")
public class OrganizationCommandController {

    private final IMediator mediator;

    public OrganizationCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CommandMessage>> create(
            @RequestBody CreateOrganizationRequest request) {
        CreateOrganizationCommand createCommand = new CreateOrganizationCommand(request);
        CommandMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<CommandMessage>> update(
            @RequestBody UpdateOrganizationRequest request) {
        UpdateOrganizationCommand command = new UpdateOrganizationCommand(request);
        CommandMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> delete(@NotBlank @PathVariable("id") UUID id) {
        DeleteOrganizationCommand command = new DeleteOrganizationCommand(id);
        CommandMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
