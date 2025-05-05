package cloud.tteams.notification.notification.application.query.getbyid;

import cloud.tteams.notification.notification.application.query.NotificationResponse;
import cloud.tteams.notification.notification.domain.Notification;
import cloud.tteams.notification.notification.domain.service.INotificationDomainService;
import cloud.tteams.notification.notification.domain.valueobject.NotificationId;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class GetByIdNotificationQueryHandler implements IQueryHandler<GetByIdNotificationQuery, NotificationResponse> {

    private final INotificationDomainService notificationService;

    public GetByIdNotificationQueryHandler(INotificationDomainService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public NotificationResponse handle(GetByIdNotificationQuery query) {
        NotificationId id = new NotificationId(query.getId());
        Notification notification = notificationService.findById(id);
        return new NotificationResponse(notification);
    }
}
