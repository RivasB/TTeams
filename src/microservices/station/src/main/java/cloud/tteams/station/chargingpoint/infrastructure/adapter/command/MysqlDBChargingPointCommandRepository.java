package cloud.tteams.station.chargingpoint.infrastructure.adapter.command;

import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointCommandRepository;
import cloud.tteams.station.chargingpoint.infrastructure.repository.hibernate.ChargingPointDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlDBChargingPointCommandRepository implements IChargingPointCommandRepository {

    private final ISpringChargingPointWriteDataJPARepository jpaRepository;

    public MysqlDBChargingPointCommandRepository(ISpringChargingPointWriteDataJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void create(ChargingPoint chargingPoint) {
        jpaRepository.save(new ChargingPointDto(chargingPoint));
    }

    @Override
    public void update(ChargingPoint chargingPoint) {
        jpaRepository.save(new ChargingPointDto(chargingPoint));
    }

    @Override
    public void delete(ChargingPoint chargingPoint) {
        jpaRepository.delete(new ChargingPointDto(chargingPoint));
    }
}
