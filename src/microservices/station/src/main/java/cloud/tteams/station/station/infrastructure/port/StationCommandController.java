package cloud.tteams.station.station.infrastructure.port;

import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.station.station.application.command.create.CreateStationCommand;
import cloud.tteams.station.station.application.command.create.CreateStationMessage;
import cloud.tteams.station.station.application.command.create.CreateStationRequest;
import cloud.tteams.station.station.application.command.delete.DeleteStationCommand;
import cloud.tteams.station.station.application.command.delete.DeleteStationMessage;
import cloud.tteams.station.station.application.command.delete.DeleteStationRequest;
import cloud.tteams.station.station.application.command.update.UpdateStationCommand;
import cloud.tteams.station.station.application.command.update.UpdateStationMessage;
import cloud.tteams.station.station.application.command.update.UpdateStationRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/station")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "EV-Station", description = " Command EV-Station API. Contains the command operations that can be " +
        "performed on a EV-Station.")
public class StationCommandController {

    private final IMediator mediator;

    public StationCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateStationMessage>> createStation(
            @RequestBody CreateStationRequest request) {
        CreateStationCommand createCommand = new CreateStationCommand(request);
        CreateStationMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateStationMessage>> updateStation(
            @RequestBody UpdateStationRequest request) {
        UpdateStationCommand updateCommand = new UpdateStationCommand(request);
        UpdateStationMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteStationMessage>> deleteStation(@NotBlank @PathVariable("id") UUID id) {
        DeleteStationRequest request = new DeleteStationRequest(id);
        DeleteStationCommand deleteCommand = new DeleteStationCommand(request);
        DeleteStationMessage response = mediator.send(deleteCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
