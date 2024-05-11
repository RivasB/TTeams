package cloud.tteams.identity.application.infrastructure.adapter.command;

import cloud.tteams.identity.application.infrastructure.repository.hibernate.AplicationDto;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringAplicationWriteDataJPARepository extends JpaRepository<AplicationDto, UUID> {

}
