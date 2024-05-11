package cloud.tteams.identity.organization.infrastructure.port;

import cloud.tteams.identity.organization.application.query.OrganizationResponse;
import cloud.tteams.identity.organization.application.query.getall.GetAllOrganizationQuery;
import cloud.tteams.identity.organization.application.query.getbyid.GetOrganizationByIdQuery;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/organization")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Organization", description = "The Organization Query API. Contains all the query operations that can be " +
        "performed on a organization.")
public class OrganizationQueryController {

    private final IMediator mediator;

    public OrganizationQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String description,
            @RequestParam(defaultValue = "") String contact,
            @RequestParam(defaultValue = "ACTIVE") State state,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        GetAllOrganizationQuery query = new GetAllOrganizationQuery(pageable, name, description, contact, state);
        MessagePaginatedResponse response = mediator.send(query);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse2xx<OrganizationResponse>> getById(@NotBlank @PathVariable UUID id) {
        GetOrganizationByIdQuery query = new GetOrganizationByIdQuery(id);
        OrganizationResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
