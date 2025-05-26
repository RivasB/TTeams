package cloud.tteams.task.task.infrastructure.port;


import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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

}
