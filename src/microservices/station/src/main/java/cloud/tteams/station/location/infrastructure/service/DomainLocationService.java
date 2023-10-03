package cloud.tteams.station.location.infrastructure.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.LocationId;
import cloud.tteams.station.location.domain.repository.ILocationCommandRepository;
import cloud.tteams.station.location.domain.repository.ILocationQueryRepository;
import cloud.tteams.station.location.domain.service.ILocationService;
import org.apache.commons.logging.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class DomainLocationService implements ILocationService {

    private final ILocationCommandRepository commandRepository;

    private final ILocationQueryRepository queryRepository;

    private final Log logger;

    public DomainLocationService(ILocationCommandRepository commandRepository, ILocationQueryRepository queryRepository, Log logger) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.logger = logger;
    }

    @Override
    public void create(Location location) {
        commandRepository.create(location);
    }

    @Override
    public void update(Location location) {
        Location toUpdateLocation = findById(location.id());
        Field[] fields = location.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object valueLocation = attrib.get(location);
                Object valueToUpdateLocation = attrib.get(toUpdateLocation);
                if (valueLocation != null && !valueLocation.equals(valueToUpdateLocation)
                        && attrib.getType().isAssignableFrom(valueLocation.getClass())) {
                    attrib.set(toUpdateLocation, valueLocation);
                }
            }
        } catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        commandRepository.update(toUpdateLocation);
    }

    @Override
    public void delete(LocationId locationId) {
        Location location = this.findById(locationId);
        commandRepository.delete(location);
    }

    @Override
    public Location findById(LocationId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }
}
