package cloud.tteams.station.station.infrastructure.port;


import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.station.station.application.StationResponse;
import cloud.tteams.station.station.application.query.getall.FindAllStationQuery;
import cloud.tteams.station.station.application.query.getbyid.FindStationByIdQuery;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/station")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-EV-Station-Station", description = " Query EV-Station API. Contains the query operations that can " +
        "be performed on a EV-Station.")
public class StationQueryController {

    private final IMediator mediator;

    public StationQueryController(IMediator mediator) {
        this.mediator = mediator;
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<StationResponse>> retrieveStationById(@NotBlank @PathVariable UUID id) {
        FindStationByIdQuery query = new FindStationByIdQuery(id);
        StationResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagePaginatedResponse> getAllStation(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        FindAllStationQuery query = new FindAllStationQuery(pageable);
        MessagePaginatedResponse response = mediator.send(query);
        return ResponseEntity.ok(response);
    }
}
