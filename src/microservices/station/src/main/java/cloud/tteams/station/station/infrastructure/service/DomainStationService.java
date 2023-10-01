package cloud.tteams.station.station.infrastructure.service;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.domain.service.IStationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class DomainStationService implements IStationService {

    private final IStationQueryRepository queryRepository;

    private final IEventService<Station> eventService;

    @Value("${kafka.messenger.station:false}")
    private boolean messengerIsActive;

    public DomainStationService(IStationQueryRepository queryRepository, IEventService<Station> eventService) {
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public Station findById(StationId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

    private boolean isValid(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }

    private void dispatch(Station data, EventType type){
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
