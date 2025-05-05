package cloud.tteams.log.log.infrastructure.port;

import cloud.tteams.log.log.application.query.LogResponse;
import cloud.tteams.share.core.application.query.FilterPageAndSortRequest;
import cloud.tteams.log.log.application.query.getall.GetAllLogQuery;
import cloud.tteams.log.log.application.query.getbyid.GetLogByIdQuery;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/log")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-Logs", description = " Logs API. Contains the query operations " +
        "that can be performed on a Log.")
public class LogQueryController {

    private final IMediator mediator;

    public LogQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogResponse> getLogById(@PathVariable UUID id) {
        GetLogByIdQuery query = new GetLogByIdQuery(id);
        LogResponse response = mediator.send(query);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/all")
    public ResponseEntity<MessagePaginatedResponse> getAllLogsPaginated(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType,
            @RequestBody(required = false) Map<String, Object> filters) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        GetAllLogQuery query = new GetAllLogQuery(filters, pageable);
        MessagePaginatedResponse pageResponse = mediator.send(query);
        return ResponseEntity.ok(pageResponse);
    }
}
