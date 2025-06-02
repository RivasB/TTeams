package cloud.tteams.task.task.infrastructure.port;

import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import cloud.tteams.task.task.application.command.assign.AssignTaskCommand;
import cloud.tteams.task.task.application.command.changestatus.ChangeTaskStatusCommand;
import cloud.tteams.task.task.application.command.create.CreateTaskCommand;
import cloud.tteams.task.task.application.command.create.CreateTaskRequest;
import cloud.tteams.task.task.application.command.delete.DeleteTaskCommand;
import cloud.tteams.task.task.application.command.logtime.LogTimeInTaskCommand;
import cloud.tteams.task.task.application.command.seteffort.SetEffortInTaskCommand;
import cloud.tteams.task.task.application.command.setorchangesprint.SetOrChangeSprintToTaskCommand;
import cloud.tteams.task.task.application.command.update.UpdateTaskCommand;
import cloud.tteams.task.task.application.command.update.UpdateTaskRequest;
import cloud.tteams.task.task.domain.valueobject.TaskStatus;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<ApiResponse2xx<CommandMessage>> createTask(@Valid @RequestBody CreateTaskRequest request) {
        CreateTaskCommand createTaskCommand = new CreateTaskCommand(request);
        CommandMessage commandMessage = mediator.send(createTaskCommand);
        return ResponseEntity.ok( new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<CommandMessage>> updateTask(@Valid @RequestBody UpdateTaskRequest request) {
        UpdateTaskCommand updateTaskCommand = new UpdateTaskCommand(request);
        CommandMessage commandMessage = mediator.send(updateTaskCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> deleteTask(@PathVariable("id") UUID id) {
        DeleteTaskCommand deleteTaskCommand = new DeleteTaskCommand(id);
        CommandMessage commandMessage = mediator.send(deleteTaskCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

    @PutMapping("{id}/assign")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> assignTask(@PathVariable("id") UUID id,
                                                                     @RequestParam() UUID user){
        AssignTaskCommand assignTaskCommand = new AssignTaskCommand(id, user);
        CommandMessage commandMessage = mediator.send(assignTaskCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

    @PutMapping("{id}/changestatus")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> changeStatus(@PathVariable("id") UUID id,
                                                                       @RequestParam(defaultValue = "PENDING") TaskStatus status) {
        ChangeTaskStatusCommand changeTaskStatusCommand = new ChangeTaskStatusCommand(id, status);
        CommandMessage commandMessage = mediator.send(changeTaskStatusCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

    @PutMapping("{id}/logtime")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> logTime(@PathVariable("id") UUID id,
                                                                  @RequestParam(defaultValue = "0") Integer hours) {
        LogTimeInTaskCommand logTimeInTaskCommand = new LogTimeInTaskCommand(id, hours);
        CommandMessage commandMessage = mediator.send(logTimeInTaskCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

    @PutMapping("{id}/seteffort")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> setEffort(@PathVariable("id") UUID id,
                                                                    @RequestParam(defaultValue = "0") Integer effort) {
        SetEffortInTaskCommand command = new SetEffortInTaskCommand(id, effort);
        CommandMessage commandMessage = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

    @PutMapping("{id}/setsprint")
    public ResponseEntity<ApiResponse2xx<CommandMessage>> setSprint(@PathVariable("id") UUID id,
                                                                    @RequestParam() UUID sprint) {
        SetOrChangeSprintToTaskCommand command = new SetOrChangeSprintToTaskCommand(id, sprint);
        CommandMessage commandMessage = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<>(commandMessage, HttpStatus.OK));
    }

}
