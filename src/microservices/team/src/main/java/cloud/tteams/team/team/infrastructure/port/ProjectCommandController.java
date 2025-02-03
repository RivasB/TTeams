package cloud.tteams.project.project.infrastructure.port;

import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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
