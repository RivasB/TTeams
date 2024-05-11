package cloud.tteams.identity.authorization.infrastructure.service;

import cloud.tteams.identity.authorization.domain.Access;
import cloud.tteams.identity.authorization.domain.AccessCode;
import cloud.tteams.identity.authorization.domain.AccessId;
import cloud.tteams.identity.authorization.domain.repository.IAccessQueryRepository;
import cloud.tteams.identity.authorization.domain.service.IAccessService;
import cloud.tteams.identity.authorization.infrastructure.exception.AccessNotFoundException;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class DomainAccessService implements IAccessService {

    private final IAccessQueryRepository queryRepository;

    @Value("${kafka.messenger.authorization:false}")
    private boolean messengerIsActive;

    public DomainAccessService(IAccessQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @Override
    public Access findById(AccessId id) {
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
    public Access findByCode(AccessCode code) {
        return queryRepository.findByCode(code.value())
                .orElseThrow(AccessNotFoundException::new);
    }

    @Override
    public Long countByIdIsNotAndCode(AccessId id, AccessCode code) {
        return queryRepository.countByIdIsNotAndCode(id.value(), code.value());
    }

}
