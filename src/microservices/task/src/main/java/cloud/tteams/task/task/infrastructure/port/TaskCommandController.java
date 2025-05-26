package cloud.tteams.task.task.infrastructure.port;

import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.task.task.application.command.create.CreateTaskCommand;
import cloud.tteams.task.task.application.command.create.CreateTaskRequest;
import cloud.tteams.task.task.application.query.TaskResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Command-Task", description = " Command Task API. Contains the command operations " +
        "that can be performed on a Task.")
public class TaskCommandController {

    private final IMediator mediator;

    public TaskCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<TaskResponse>> createTask(@Valid @RequestBody CreateTaskRequest request) {
        CreateTaskCommand createTaskCommand = new CreateTaskCommand(request);
        TaskResponse taskResponse = mediator.send(createTaskCommand);
        return ResponseEntity.ok( new ApiResponse2xx<>(taskResponse, HttpStatus.OK));
    }

}
