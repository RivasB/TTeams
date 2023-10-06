package cloud.tteams.station.location.infrastructure.port;


import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.station.chargingpoint.application.ChargingPointResponse;
import cloud.tteams.station.chargingpoint.application.query.getall.FindAllChargingPointQuery;
import cloud.tteams.station.chargingpoint.application.query.getbyid.FindChargingPointByIdQuery;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/chargingpoint")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-EV-Station-ChargingPoint", description = " Command EV-Station-ChargingPoint API. Contains the " +
        "command operations that can be performed on a EV-Station-ChargingPoint.")
public class LocationQueryController {

    private final IMediator mediator;

    public LocationQueryController(IMediator mediator) {
        this.mediator = mediator;
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<ChargingPointResponse>> retrieveChargingPointById(@NotBlank @PathVariable UUID id) {
        FindChargingPointByIdQuery query = new FindChargingPointByIdQuery(id);
        ChargingPointResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagePaginatedResponse> getAllChargingPoint(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        FindAllChargingPointQuery query = new FindAllChargingPointQuery(pageable);
        MessagePaginatedResponse response = mediator.send(query);
        return ResponseEntity.ok(response);
    }
}
