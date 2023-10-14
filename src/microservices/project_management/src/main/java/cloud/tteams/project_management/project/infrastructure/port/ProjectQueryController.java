package cloud.tteams.project_management.project.infrastructure.port;


import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/project")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-Project", description = " Query Project API. Contains the query operations that can " +
        "be performed on a Project.")
public class ProjectQueryController {

    private final IMediator mediator;

    public ProjectQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

}
