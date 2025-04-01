package cloud.tteams.project.project.infrastructure.port;


import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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

}
