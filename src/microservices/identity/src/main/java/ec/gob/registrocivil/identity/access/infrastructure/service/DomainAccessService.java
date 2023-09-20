package ec.gob.registrocivil.identity.access.infrastructure.service;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.identity.access.domain.AccessCode;
import ec.gob.registrocivil.identity.access.domain.AccessId;
import ec.gob.registrocivil.identity.access.domain.repository.IAccessQueryRepository;
import ec.gob.registrocivil.identity.access.domain.service.IAccessService;
import ec.gob.registrocivil.identity.access.infrastructure.exception.AccessNotFoundException;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;

public class DomainAccessService implements IAccessService {

    private final IAccessQueryRepository queryRepository;

    @Value("${kafka.messenger.access:false}")
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
