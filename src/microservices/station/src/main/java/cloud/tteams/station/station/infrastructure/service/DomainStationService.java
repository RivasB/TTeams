package cloud.tteams.station.station.infrastructure.service;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.domain.service.IStationService;
import cloud.tteams.station.station.infrastructure.exception.StationNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;

public class DomainStationService implements IStationService {

    private final IStationQueryRepository queryRepository;

    @Value("${kafka.messenger.access:false}")
    private boolean messengerIsActive;

    public DomainStationService(IStationQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @Override
    public Station findById(StationId id) {
        return queryRepository.findById(id)
                .orElseThrow(StationNotFoundException::new);
    }

    @Override
    public MessagePaginatedResponse getPaginatedAccess(Pageable pageable, String description, String code, String resource) {
        return queryRepository.findAll(pageable, description, code, resource);
    }

    private boolean isValid(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }

}
