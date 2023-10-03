package cloud.tteams.station.chargingpoint.infrastructure.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointCommandRepository;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointQueryRepository;
import cloud.tteams.station.chargingpoint.domain.service.IChargingPointService;
import org.apache.commons.logging.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class DomainChargingPointService implements IChargingPointService {

    private final IChargingPointCommandRepository commandRepository;

    private final IChargingPointQueryRepository queryRepository;

    private final Log logger;

    public DomainChargingPointService(IChargingPointCommandRepository commandRepository,
                                      IChargingPointQueryRepository queryRepository, Log logger) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.logger = logger;
    }

    @Override
    public void create(ChargingPoint chargingPoint) {
        commandRepository.create(chargingPoint);
    }

    @Override
    public void update(ChargingPoint chargingPoint) {
        ChargingPoint toUpdateChargingPoint = findById(chargingPoint.id());
        Field[] fields = chargingPoint.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object valueChargingPoint = attrib.get(chargingPoint);
                Object valueToUpdateChargingPoint = attrib.get(toUpdateChargingPoint);
                if (valueChargingPoint != null && !valueChargingPoint.equals(valueToUpdateChargingPoint)
                        && attrib.getType().isAssignableFrom(valueChargingPoint.getClass())) {
                    attrib.set(toUpdateChargingPoint, valueChargingPoint);
                }
            }
        } catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        commandRepository.update(toUpdateChargingPoint);
    }

    @Override
    public void delete(ChargingPointId chargingPointId) {
        ChargingPoint chargingPoint = this.findById(chargingPointId);
        commandRepository.delete(chargingPoint);
    }

    @Override
    public ChargingPoint findById(ChargingPointId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }
}
