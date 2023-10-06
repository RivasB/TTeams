package cloud.tteams.station.location.infrastructure.port;


import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.station.location.application.LocationResponse;
import cloud.tteams.station.location.application.query.getall.FindAllLocationQuery;
import cloud.tteams.station.location.application.query.getbyid.FindLocationByIdQuery;
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
@RequestMapping("/api/location")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-EV-Station-Location", description = " Command EV-Station-Location API. Contains the command operations that can " +
        "be performed on a EV-Station-Location.")
public class LocationQueryController {

    private final IMediator mediator;

    public LocationQueryController(IMediator mediator) {
        this.mediator = mediator;
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<LocationResponse>> retrieveLocationById(@NotBlank @PathVariable UUID id) {
        FindLocationByIdQuery query = new FindLocationByIdQuery(id);
        LocationResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagePaginatedResponse> getAllLocation(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "address") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        FindAllLocationQuery query = new FindAllLocationQuery(pageable);
        MessagePaginatedResponse response = mediator.send(query);
        return ResponseEntity.ok(response);
    }
}
