package cloud.tteams.notification.notification.infrastructure.port;

import cloud.tteams.notification.notification.application.command.StatusRequest;
import cloud.tteams.notification.notification.application.command.delete.DeleteNotificationCommand;
import cloud.tteams.notification.notification.application.command.setstatus.SetStatusNotificationCommand;
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
@RequestMapping("/api/notification")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Command-Notification", description = " Command Notification API. Contains the command operations " +
        "that can be performed on a Notification.")
public class NotificationCommandController {

    private final IMediator mediator;

    public NotificationCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PutMapping
    private ResponseEntity<ApiResponse2xx<ICommandMessage>> setNotificationStatus(@RequestBody @Valid StatusRequest request) {
        ICommandMessage message = mediator.send(new SetStatusNotificationCommand(request));
        return ResponseEntity.ok(new ApiResponse2xx<>(message, HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteNotification(@PathVariable("id") @NotNull UUID id){
        mediator.send(new DeleteNotificationCommand(id));
        return  ResponseEntity.noContent().build();
    }

}
