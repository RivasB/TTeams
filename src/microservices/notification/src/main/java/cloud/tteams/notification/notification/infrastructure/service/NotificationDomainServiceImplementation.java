package cloud.tteams.notification.notification.infrastructure.service;

import cloud.tteams.notification.notification.domain.Notification;
import cloud.tteams.notification.notification.domain.exception.NotificationNotFoundException;
import cloud.tteams.notification.notification.domain.service.INotificationDomainService;
import cloud.tteams.notification.notification.domain.valueobject.NotificationId;
import cloud.tteams.notification.notification.domain.valueobject.NotificationRecipient;
import cloud.tteams.notification.notification.infrastructure.adapter.command.INotificationCommandJPARepository;
import cloud.tteams.notification.notification.infrastructure.adapter.query.INotificationQueryJPARepository;
import cloud.tteams.notification.notification.infrastructure.repository.hibernate.NotificationEntity;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class NotificationDomainServiceImplementation implements INotificationDomainService {

    private final INotificationCommandJPARepository commandRepository;
    private final INotificationQueryJPARepository queryRepository;

    public NotificationDomainServiceImplementation(INotificationCommandJPARepository commandRepository, INotificationQueryJPARepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    @Override
    public Page<Notification> findAllByRecipient(NotificationRecipient recipient, Pageable pageable) {
        Page<NotificationEntity> entities = queryRepository.findAllByRecipientUuid(recipient.value(), pageable);
        return entities.map(NotificationEntity::toAggregate);
    }

    @Override
    public Notification findById(NotificationId id) {
        NotificationEntity entity = getNotificationEntity(id);
        return entity.toAggregate();
    }

    @Override
    public void create(Notification notification) {
        NotificationEntity entity = new NotificationEntity(notification);
        commandRepository.save(entity);
    }

    @Override
    public Notification setStatus(NotificationId id, NotificationStatus status) {
        NotificationEntity entity = getNotificationEntity(id);
        entity.setStatus(status);
        return commandRepository.save(entity).toAggregate();
    }

    @Override
    public void delete(NotificationId id) {
        setStatus(id, NotificationStatus.DELETED);
    }

    private NotificationEntity getNotificationEntity(NotificationId id) {
        return queryRepository.findById(id.value()).orElseThrow(NotificationNotFoundException::new);
    }
}
