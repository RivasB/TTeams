package cloud.tteams.identity.geographiclocation.infrastructure.port;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.tteams.identity.geographiclocation.application.command.create.CreateGeographicLocationCommand;
import cloud.tteams.identity.geographiclocation.application.command.create.CreateGeographicLocationMessage;
import cloud.tteams.identity.geographiclocation.application.command.create.CreateGeographicLocationRequest;
import cloud.tteams.identity.geographiclocation.application.command.delete.DeleteGeographicLocationCommand;
import cloud.tteams.identity.geographiclocation.application.command.delete.DeleteGeographicLocationMessage;
import cloud.tteams.identity.geographiclocation.application.command.update.UpdateGeographicLocationCommand;
import cloud.tteams.identity.geographiclocation.application.command.update.UpdateGeographicLocationMessage;
import cloud.tteams.identity.geographiclocation.application.command.update.UpdateGeographicLocationRequest;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/backoffice/location")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "BackOffice Geographic Location", description = "The Geographic Location API. Contains all the operations that can be performed on a Geographic Location.")
public class GeographicLocationBackOfficeController {

    private final IMediator mediator;

    public GeographicLocationBackOfficeController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateGeographicLocationMessage>> createLocation(
            @RequestBody CreateGeographicLocationRequest request) {

        CreateGeographicLocationCommand createCommand = CreateGeographicLocationCommand.fromRequest(request);
        CreateGeographicLocationMessage response = mediator.send(createCommand);

        return ResponseEntity.ok(new ApiResponse2xx<CreateGeographicLocationMessage>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateGeographicLocationMessage>> updateLocation(
            @RequestBody UpdateGeographicLocationRequest request) {

        UpdateGeographicLocationCommand createCommand = UpdateGeographicLocationCommand.fromRequest(request);
        UpdateGeographicLocationMessage response = mediator.send(createCommand);

        return ResponseEntity.ok(new ApiResponse2xx<UpdateGeographicLocationMessage>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteGeographicLocationMessage>> deleteLocation(
            @NotBlank @PathVariable UUID id) {

        DeleteGeographicLocationCommand deleteCommand = new DeleteGeographicLocationCommand();
        DeleteGeographicLocationMessage response = mediator.send(deleteCommand);

        return ResponseEntity.ok(new ApiResponse2xx<DeleteGeographicLocationMessage>(response, HttpStatus.OK));
    }
}
