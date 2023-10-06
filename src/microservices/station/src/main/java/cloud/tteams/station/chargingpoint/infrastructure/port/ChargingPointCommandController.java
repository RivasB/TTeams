package cloud.tteams.station.chargingpoint.infrastructure.port;

import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.station.chargingpoint.application.command.create.CreateChargingPointCommand;
import cloud.tteams.station.chargingpoint.application.command.create.CreateChargingPointMessage;
import cloud.tteams.station.chargingpoint.application.command.create.CreateChargingPointRequest;
import cloud.tteams.station.chargingpoint.application.command.delete.DeleteChargingPointCommand;
import cloud.tteams.station.chargingpoint.application.command.delete.DeleteChargingPointMessage;
import cloud.tteams.station.chargingpoint.application.command.delete.DeleteChargingPointRequest;
import cloud.tteams.station.chargingpoint.application.command.update.UpdateChargingPointCommand;
import cloud.tteams.station.chargingpoint.application.command.update.UpdateChargingPointMessage;
import cloud.tteams.station.chargingpoint.application.command.update.UpdateChargingPointRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/chargingpoint")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Command-EV-Station-ChargingPoint", description = " Command EV-Station-ChargingPoint API. Contains the " +
        "command operations that can be performed on a EV-Station-ChargingPoint.")
public class ChargingPointCommandController {

    private final IMediator mediator;

    public ChargingPointCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateChargingPointMessage>> createChargingPoint(
            @RequestBody CreateChargingPointRequest request) {
        CreateChargingPointCommand createCommand = new CreateChargingPointCommand(request);
        CreateChargingPointMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateChargingPointMessage>> updateChargingPoint(
            @RequestBody UpdateChargingPointRequest request) {
        UpdateChargingPointCommand updateCommand = new UpdateChargingPointCommand(request);
        UpdateChargingPointMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteChargingPointMessage>> deleteChargingPoint(@NotBlank @PathVariable("id") UUID id) {
        DeleteChargingPointRequest request = new DeleteChargingPointRequest(id);
        DeleteChargingPointCommand deleteCommand = new DeleteChargingPointCommand(request);
        DeleteChargingPointMessage response = mediator.send(deleteCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
