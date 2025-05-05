package cloud.tteams.project.project.infrastructure.port;

import cloud.tteams.project.project.application.command.create.CreateProjectCommand;
import cloud.tteams.project.project.application.command.create.CreateProjectRequest;
import cloud.tteams.project.project.application.command.delete.DeleteProjectCommand;
import cloud.tteams.project.project.application.command.update.UpdateProjectCommand;
import cloud.tteams.project.project.application.command.update.UpdateProjectRequest;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/project")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Command-Project", description = " Command Project API. Contains the command operations " +
        "that can be performed on a Project.")
public class ProjectCommandController {

    private final IMediator mediator;

    public ProjectCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    private ResponseEntity<ApiResponse2xx<ICommandMessage>> createProject(@RequestBody @Valid CreateProjectRequest request) {
        ICommandMessage message = mediator.send(new CreateProjectCommand(request));
        return ResponseEntity.ok(new ApiResponse2xx<>(message, HttpStatus.OK));
    }

    @PutMapping
    private ResponseEntity<ApiResponse2xx<ICommandMessage>> updateProject(@RequestBody @Valid UpdateProjectRequest request) {
        ICommandMessage message = mediator.send(new UpdateProjectCommand(request));
        return ResponseEntity.ok(new ApiResponse2xx<>(message, HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteProject(@PathVariable("id") @NotNull UUID id){
        mediator.send(new DeleteProjectCommand(id));
        return  ResponseEntity.noContent().build();
    }

}
