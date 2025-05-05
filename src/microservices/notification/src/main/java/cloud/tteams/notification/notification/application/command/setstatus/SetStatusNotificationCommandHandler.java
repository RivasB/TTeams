package cloud.tteams.notification.notification.application.command.setstatus;

import cloud.tteams.notification.notification.domain.service.INotificationDomainService;
import cloud.tteams.notification.notification.domain.valueobject.NotificationId;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class SetStatusNotificationCommandHandler implements ICommandHandler<SetStatusNotificationCommand> {

    private final INotificationDomainService notificationDomainService;

    public SetStatusNotificationCommandHandler(INotificationDomainService notificationDomainService) {
        this.notificationDomainService = notificationDomainService;
    }

    @Override
    public void handle(SetStatusNotificationCommand command) {
        NotificationId id = new NotificationId(command.getId());
        notificationDomainService.setStatus(id, command.getStatus());
    }
}
