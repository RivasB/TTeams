package cloud.tteams.identity.authorization.infrastructure.port;

import cloud.tteams.identity.authorization.application.AuthorizationResponse;
import cloud.tteams.identity.authorization.application.query.getall.GetAllAuthorizationQuery;
import cloud.tteams.identity.authorization.application.query.getbyid.GetByIdAuthorizationQuery;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/authorization")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Authorization", description = "The Authorization API. Contains all the query operations that can be " +
        "performed on a authorization.")
public class AuthorizationQueryController {

    private final IMediator mediator;

    public AuthorizationQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse2xx<AuthorizationResponse>> getById(@NotBlank @PathVariable UUID id) {
        GetByIdAuthorizationQuery query = new GetByIdAuthorizationQuery(id);
        AuthorizationResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String resource,
            @RequestParam(defaultValue = "") AuthorizedAction action,
            @RequestParam(defaultValue = "") State state,
            @RequestParam(defaultValue = "code") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        GetAllAuthorizationQuery findQuery = new GetAllAuthorizationQuery(pageable, name, resource, action, state);
        MessagePaginatedResponse pageResponse = mediator.send(findQuery);
        return ResponseEntity.ok(pageResponse);
    }
}
