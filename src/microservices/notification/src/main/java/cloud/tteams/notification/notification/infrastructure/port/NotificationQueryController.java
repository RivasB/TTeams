package cloud.tteams.notification.notification.infrastructure.port;


import cloud.tteams.notification.notification.application.query.NotificationResponse;
import cloud.tteams.notification.notification.application.query.getall.GetAllNotificationQuery;
import cloud.tteams.notification.notification.application.query.getbyid.GetByIdNotificationQuery;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/notification")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Query-Notification", description = " Query Notification API. Contains the query operations that can " +
        "be performed on a Notification.")
public class NotificationQueryController {

    private final IMediator mediator;

    public NotificationQueryController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/all/{recipient}")
    public ResponseEntity<MessagePaginatedResponse> getAllNotificationPaginated(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType,
            @PathVariable UUID recipient) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        GetAllNotificationQuery query = new GetAllNotificationQuery(recipient,pageable);
        MessagePaginatedResponse pageResponse = mediator.send(query);
        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<NotificationResponse>> getNotificationById(@PathVariable UUID id) {
        GetByIdNotificationQuery query = new GetByIdNotificationQuery(id);
        NotificationResponse response = mediator.send(query);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

}
