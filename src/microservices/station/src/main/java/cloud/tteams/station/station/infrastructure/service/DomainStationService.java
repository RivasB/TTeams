package cloud.tteams.station.station.infrastructure.service;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.repository.IStationCommandRepository;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.domain.service.IStationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class DomainStationService implements IStationService {

    private final IStationCommandRepository commandRepository;

    private final IStationQueryRepository queryRepository;

    private final IEventService<Station> eventService;

    private final Log logger = LogFactory.getLog(this.getClass());

    @Value("${kafka.messenger.station:false}")
    private boolean messengerIsActive;

    public DomainStationService(IStationCommandRepository commandRepository, IStationQueryRepository queryRepository,
                                IEventService<Station> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void create(Station station) {
        commandRepository.create(station);
        publishEvent(station, EventType.CREATED);
    }

    @Override
    public void update(Station station) {
        Station toUpdateStation = findById(station.getId());
        Field[] fields = station.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object valueStation = attrib.get(station);
                Object valueToUpdateStation = attrib.get(toUpdateStation);
                if (valueStation != null && !valueStation.equals(valueToUpdateStation)
                        && attrib.getType().isAssignableFrom(valueStation.getClass())) {
                    attrib.set(toUpdateStation, valueStation);
                }
            }
        } catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        commandRepository.update(toUpdateStation);
        publishEvent(toUpdateStation, EventType.UPDATED);
    }

    @Override
    public void delete(StationId stationId) {
        Station station = this.findById(stationId);
        commandRepository.delete(stationId);
        publishEvent(station, EventType.DELETED);
    }

    @Override
    public Station findById(StationId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

    private void publishEvent(Station data, EventType type){
        if (messengerIsActive){
            switch(type) {
                case CREATED:
                    eventService.create(data);
                    break;
                case UPDATED:
                    eventService.update(data);
                    break;
                case DELETED:
                    eventService.delete(data);
                    break;
                default:
                    // do nothing
            }
        }
    }

}
