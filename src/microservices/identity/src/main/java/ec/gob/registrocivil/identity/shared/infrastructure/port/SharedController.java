package ec.gob.registrocivil.identity.shared.infrastructure.port;

import ec.gob.registrocivil.identity.shared.application.spread.SpreadCommand;
import ec.gob.registrocivil.identity.shared.application.spread.SpreadMessage;
import ec.gob.registrocivil.share.core.application.ApiResponse2xx;
import ec.gob.registrocivil.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shared")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "BackOffice Shared API", description = "The Shared API.")
public class SharedController {

    private final IMediator mediator;

    public SharedController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/spread")
    public ResponseEntity<ApiResponse2xx<SpreadMessage>> spreadUsers() {
        SpreadCommand command = new SpreadCommand();
        SpreadMessage response = mediator.send(command);
        return ResponseEntity.ok(new ApiResponse2xx<SpreadMessage>(response, HttpStatus.OK));
    }

}
