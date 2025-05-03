package cloud.tteams.log.log.infrastructure.service;

import cloud.tteams.log.log.domain.Log;
import cloud.tteams.log.log.domain.service.ILogDomainService;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.message.log.LogDataMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LogConsumerService {

    private final ILogDomainService logDomainService;

    public LogConsumerService(ILogDomainService logDomainService) {
        this.logDomainService = logDomainService;
    }

    @KafkaListener(topics = "log-topic", groupId = "log-subscriber-group")
    public void consumeLogEvent(ConsumerRecord<String, Event> record) {
        try {
            Event logEvent = record.value();
            LogDataMessage logData = (LogDataMessage) logEvent.getData();
            Log log = new Log(logData);
            logDomainService.create(log);
        } catch (Exception e) {
            System.err.println("Error processing log event: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
