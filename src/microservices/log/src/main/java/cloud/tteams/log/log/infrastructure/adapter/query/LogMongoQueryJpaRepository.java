package cloud.tteams.log.log.infrastructure.adapter.query;

import cloud.tteams.log.log.infrastructure.repository.document.LogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogMongoQueryJpaRepository extends MongoRepository<LogDocument, UUID> {
}
