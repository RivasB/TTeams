package cloud.tteams.task.task.infrastructure.port;


import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.task.task.application.query.TaskResponse;
import cloud.tteams.task.task.application.query.getall.GetAllTaskQuery;
import cloud.tteams.task.task.application.query.getbyid.GetTaskByIdQuery;
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
@RequestMapping("/api/task")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-Task", description = " Query Task API. Contains the query operations that can " +
        "be performed on a Task.")
public class TaskQueryController {

    private final IMediator mediator;

    public TaskQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable("id") UUID id) {
        TaskResponse taskResponse = mediator.send(new GetTaskByIdQuery(id));
        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping("all")
    public ResponseEntity<?> getAllTasks(@RequestParam(defaultValue = "0") Integer pageNo,
                                         @RequestParam(defaultValue = "20") Integer pageSize,
                                         @RequestParam(defaultValue = "name") String sortBy,
                                         @RequestParam(defaultValue = "asc") String sortType,
                                         @RequestBody(required = false) Map<String, Object> filters) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        GetAllTaskQuery query = new GetAllTaskQuery(filters, pageable);
        MessagePaginatedResponse response = mediator.send(query);
        return ResponseEntity.ok(response);
    }




}
