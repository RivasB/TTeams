package cloud.tteams.identity.access.infrastructure.service;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.identity.access.domain.AccessCode;
import cloud.tteams.identity.access.domain.AccessId;
import cloud.tteams.identity.access.domain.repository.IStationQueryRepository;
import cloud.tteams.identity.access.domain.service.IStationService;
import cloud.tteams.identity.access.infrastructure.exception.AccessNotFoundException;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;

public class DomainAccessService implements IStationService {

    private final IStationQueryRepository queryRepository;

    @Value("${kafka.messenger.access:false}")
    private boolean messengerIsActive;

    public DomainAccessService(IStationQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @Override
    public Station findById(AccessId id) {
        return queryRepository.findById(id)
                .orElseThrow(AccessNotFoundException::new);
    }

    @Override
    public MessagePaginatedResponse getPaginatedAccess(Pageable pageable, String description, String code, String resource) {
        
        return queryRepository.findAll(pageable, description, code, resource);
    }
//    @Override
//    public MessagePaginatedResponse getPaginatedAccess(Pageable pageable, String filter) {
//        if (isValid(filter)) {
//            return queryRepository.allAccessWithFilter(pageable, filter);
//        }
//
//        return queryRepository.allAccessWithOutFilter(pageable);
//    }

    private boolean isValid(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }

    @Override
    public Station findByCode(AccessCode code) {
        return queryRepository.findByCode(code.value())
                .orElseThrow(AccessNotFoundException::new);
    }

    @Override
    public Long countByIdIsNotAndCode(AccessId id, AccessCode code) {
        return queryRepository.countByIdIsNotAndCode(id.value(), code.value());
    }

}
