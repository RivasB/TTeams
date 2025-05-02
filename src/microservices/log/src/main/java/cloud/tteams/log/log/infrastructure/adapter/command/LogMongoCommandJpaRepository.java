package cloud.tteams.log.log.infrastructure.adapter.command;

import cloud.tteams.log.log.infrastructure.repository.document.LogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogMongoCommandJpaRepository extends MongoRepository<LogDocument, UUID> {
}
