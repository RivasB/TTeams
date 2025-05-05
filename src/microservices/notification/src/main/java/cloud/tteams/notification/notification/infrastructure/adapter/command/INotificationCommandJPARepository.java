package cloud.tteams.notification.notification.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.notification.notification.infrastructure.repository.hibernate.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationCommandJPARepository extends JpaRepository<NotificationEntity, UUID> {
}
