package cloud.tteams.notification.notification.application.query.getall;

import cloud.tteams.notification.notification.application.query.NotificationResponse;
import cloud.tteams.notification.notification.domain.Notification;
import cloud.tteams.notification.notification.domain.service.INotificationDomainService;
import cloud.tteams.notification.notification.domain.valueobject.NotificationRecipient;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class GetAllNotificationQueryHandler implements IQueryHandler<GetAllNotificationQuery, MessagePaginatedResponse> {

    private final INotificationDomainService notificationDomainService;

    public GetAllNotificationQueryHandler(INotificationDomainService notificationDomainService) {
        this.notificationDomainService = notificationDomainService;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllNotificationQuery query) {
        NotificationRecipient recipient = new NotificationRecipient(query.getRecipient());
        Page<Notification> notificationPage = notificationDomainService.findAllByRecipient(recipient, query.getPageable());
        Page<NotificationResponse> responsePage = notificationPage.map(NotificationResponse::new);
        return new MessagePaginatedResponse(responsePage);
    }
}
