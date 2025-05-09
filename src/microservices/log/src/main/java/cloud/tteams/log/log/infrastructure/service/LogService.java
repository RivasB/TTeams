package cloud.tteams.log.log.infrastructure.service;

import cloud.tteams.log.log.domain.Log;
import cloud.tteams.log.log.domain.exception.LogNotFoundException;
import cloud.tteams.log.log.domain.service.ILogDomainService;
import cloud.tteams.log.log.domain.valueobject.LogId;
import cloud.tteams.log.log.infrastructure.repository.document.LogDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class LogService implements ILogDomainService {

    private final MongoTemplate mongoTemplate;

    public LogService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void create(Log log) {
        LogDocument logDocument = new LogDocument(log);
        mongoTemplate.save(logDocument);
    }

    @Override
    public Log getById(LogId id) {
        LogDocument logDocument = Optional.ofNullable(mongoTemplate.findById(id.value(), LogDocument.class))
                                           .orElseThrow(LogNotFoundException::new);
        return logDocument.toAggregate();
    }

    @Override
    public Page<Log> getAll(Pageable pageable, Map<String, Object> filters) {
        Query query = new Query();
        if (filters != null) {
            filters.forEach((key, value) -> query.addCriteria(Criteria.where(key).is(value)));
        }
        long total = mongoTemplate.count(query, LogDocument.class);
        query.with(pageable);
        List<LogDocument> documents = mongoTemplate.find(query, LogDocument.class);
        return new PageImpl<>(
                documents.stream().map(LogDocument::toAggregate).toList(),
                pageable, total);
    }
}
