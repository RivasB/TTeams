package cloud.tteams.notification.notification.application.command.delete;

import cloud.tteams.notification.notification.domain.service.INotificationDomainService;
import cloud.tteams.notification.notification.domain.valueobject.NotificationId;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteNotificationCommandHandler implements ICommandHandler<DeleteNotificationCommand> {

    private final INotificationDomainService notificationDomainService;

    public DeleteNotificationCommandHandler(INotificationDomainService notificationDomainService) {
        this.notificationDomainService = notificationDomainService;
    }

    @Override
    public void handle(DeleteNotificationCommand command) {
        NotificationId id = new NotificationId(command.getId());
        notificationDomainService.delete(id);
    }
}
