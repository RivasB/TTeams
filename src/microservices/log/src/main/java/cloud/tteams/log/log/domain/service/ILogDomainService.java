package cloud.tteams.log.log.domain.service;

import cloud.tteams.log.log.domain.Log;
import cloud.tteams.log.log.domain.valueobject.LogId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ILogDomainService {
    void create(Log log);
    Log getById(LogId id);
    Page<Log> getAll(Pageable pageable, Map<String, Object> filters);
}
