package cloud.tteams.station.chargingpoint.infrastructure.port;

import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.station.location.application.command.create.CreateLocationCommand;
import cloud.tteams.station.location.application.command.create.CreateLocationMessage;
import cloud.tteams.station.location.application.command.create.CreateLocationRequest;
import cloud.tteams.station.location.application.command.delete.DeleteLocationCommand;
import cloud.tteams.station.location.application.command.delete.DeleteLocationMessage;
import cloud.tteams.station.location.application.command.delete.DeleteLocationRequest;
import cloud.tteams.station.location.application.command.update.UpdateLocationCommand;
import cloud.tteams.station.location.application.command.update.UpdateLocationMessage;
import cloud.tteams.station.location.application.command.update.UpdateLocationRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/location")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Command-EV-Station-Location", description = " Command EV-Station-Location API. Contains the command operations that can " +
        "be performed on a EV-Station-Location.")
public class ChargingPointCommandController {

    private final IMediator mediator;

    public ChargingPointCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateLocationMessage>> createLocation(
            @RequestBody CreateLocationRequest request) {
        CreateLocationCommand createCommand = new CreateLocationCommand(request);
        CreateLocationMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateLocationMessage>> updateLocation(
            @RequestBody UpdateLocationRequest request) {
        UpdateLocationCommand updateCommand = new UpdateLocationCommand(request);
        UpdateLocationMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteLocationMessage>> deleteLocation(@NotBlank @PathVariable("id") UUID id) {
        DeleteLocationRequest request = new DeleteLocationRequest(id);
        DeleteLocationCommand deleteCommand = new DeleteLocationCommand(request);
        DeleteLocationMessage response = mediator.send(deleteCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
