package cloud.tteams.identity.authorization.infrastructure.port;

import cloud.tteams.identity.authorization.application.query.getall.FindAccessWithFilterQuery;
import cloud.tteams.identity.authorization.application.query.getbyid.FindAccessByIdQuery;
import cloud.tteams.identity.authorization.application.query.getbyid.FindAccessByIdResponse;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
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
@RequestMapping("/api/access")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Access", description = "The Access API. Contains all the operations that can be performed on a authorization.")
public class AccessController {

    private final IMediator mediator;

    public AccessController(IMediator mediator) {
        this.mediator = mediator;
    }

    // This workflow is implemented by 06-RFS4. Gestionar Permisos
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse2xx<FindAccessByIdResponse>> retrieveAccess(@NotBlank @PathVariable UUID id) {

        FindAccessByIdQuery query = new FindAccessByIdQuery(id);
        FindAccessByIdResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<FindAccessByIdResponse>(response, HttpStatus.OK));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagePaginatedResponse> getAllAccess(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String description,
            @RequestParam(defaultValue = "") String code,
            @RequestParam(defaultValue = "") String resource,
            @RequestParam(defaultValue = "code") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {

        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindAccessWithFilterQuery findQuery = new FindAccessWithFilterQuery(pageable, description, code, resource);
        MessagePaginatedResponse pageResponse = mediator.send(findQuery);

        return ResponseEntity.ok(pageResponse);
    }
}
