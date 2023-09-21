package cloud.tteams.identity.geographiclocation.infrastructure.port;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.tteams.identity.geographiclocation.application.query.getall.FindGeographicLocationWithFilterQuery;
import cloud.tteams.identity.geographiclocation.application.query.getallbyparent.FindGeographicLocationGetAllByParentQuery;
import cloud.tteams.identity.geographiclocation.application.query.getbyid.FindGeographicLocationByIdQuery;
import cloud.tteams.identity.geographiclocation.application.query.getbyid.FindGeographicLocationByIdResponse;
import cloud.tteams.identity.geographiclocation.application.query.getbytype.FindGeographicLocationByTypeQuery;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/location")
@Tag(name = "Client Geographic Location", description = "The Geographic Location API. Contains all the operations that can be performed on a Geographic Location.")
public class GeographicLocationClientController {

    private final IMediator mediator;

    public GeographicLocationClientController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAllLocations(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindGeographicLocationWithFilterQuery query = new FindGeographicLocationWithFilterQuery(pageable, filter);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/country")
    public ResponseEntity<MessagePaginatedResponse> getAllCities(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindGeographicLocationByTypeQuery query = new FindGeographicLocationByTypeQuery(pageable, filter,
                GeographicLocationType.COUNTRY);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/province")
    public ResponseEntity<MessagePaginatedResponse> getAllProvince(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindGeographicLocationByTypeQuery query = new FindGeographicLocationByTypeQuery(pageable, filter,
                GeographicLocationType.PROVINCE);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/canton")
    public ResponseEntity<MessagePaginatedResponse> getAllCanton(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindGeographicLocationByTypeQuery query = new FindGeographicLocationByTypeQuery(pageable, filter,
                GeographicLocationType.CANTON);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/parroquia")
    public ResponseEntity<MessagePaginatedResponse> getAllParroquia(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindGeographicLocationByTypeQuery query = new FindGeographicLocationByTypeQuery(pageable, filter,
                GeographicLocationType.PARROQUIA);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/parent/{id}")
    public ResponseEntity<MessagePaginatedResponse> getAllByParent(
            @NotBlank @PathVariable UUID id) {
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(0, 20, sort);

        FindGeographicLocationGetAllByParentQuery query = new FindGeographicLocationGetAllByParentQuery(pageable, id);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<FindGeographicLocationByIdResponse>> getLocation(
            @NotBlank @PathVariable UUID id) {

        FindGeographicLocationByIdQuery query = new FindGeographicLocationByIdQuery(id);
        FindGeographicLocationByIdResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindGeographicLocationByIdResponse>(response, HttpStatus.OK));
    }

}
