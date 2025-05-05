package cloud.tteams.notification.notification.infrastructure.adapter.query;

import cloud.tteams.notification.notification.infrastructure.repository.hibernate.NotificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface INotificationQueryJPARepository extends JpaRepository<NotificationEntity, UUID> {
    Page<NotificationEntity> findAllByRecipientUuid(UUID value, Pageable pageable);
}
