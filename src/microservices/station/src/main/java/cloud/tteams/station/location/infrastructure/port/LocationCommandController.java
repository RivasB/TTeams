package cloud.tteams.station.location.infrastructure.port;

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
public class LocationCommandController {

    private final IMediator mediator;

    public LocationCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateLocationMessage>> updateLocation(
            @RequestBody UpdateLocationRequest request) {
        UpdateLocationCommand updateCommand = new UpdateLocationCommand(request);
        UpdateLocationMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
