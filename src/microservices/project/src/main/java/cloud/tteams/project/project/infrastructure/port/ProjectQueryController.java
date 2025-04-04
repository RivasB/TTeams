package cloud.tteams.project.project.infrastructure.port;


import cloud.tteams.project.project.application.query.ProjectResponse;
import cloud.tteams.project.project.application.query.getall.GetAllProjectQuery;
import cloud.tteams.project.project.application.query.getbyid.GetByIdProjectQuery;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/project")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-Project", description = " Query Project API. Contains the query operations that can " +
        "be performed on a Project.")
public class ProjectQueryController {

    private final IMediator mediator;

    public ProjectQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/all")
    public ResponseEntity<MessagePaginatedResponse> getAllProjectPaginated(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType,
            @RequestBody(required = false) Map<String, Object> filters) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        GetAllProjectQuery query = new GetAllProjectQuery(filters,pageable);
        MessagePaginatedResponse pageResponse = mediator.send(query);
        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable UUID id) {
        GetByIdProjectQuery query = new GetByIdProjectQuery(id);
        ProjectResponse projectResponse = mediator.send(query);
        return ResponseEntity.ok(projectResponse);
    }

}
