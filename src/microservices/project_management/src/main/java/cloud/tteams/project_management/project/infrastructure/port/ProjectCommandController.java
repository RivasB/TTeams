package cloud.tteams.project_management.project.infrastructure.port;

import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/project")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Command-Project", description = " Command Project API. Contains the command operations " +
        "that can be performed on a Project.")
public class ProjectCommandController {

    private final IMediator mediator;

    public ProjectCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

}
