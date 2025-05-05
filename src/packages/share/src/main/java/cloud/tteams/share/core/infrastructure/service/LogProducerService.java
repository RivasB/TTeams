package cloud.tteams.share.core.infrastructure.service;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.config.context.session.UserSession;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.log.LogDataMessage;
import cloud.tteams.share.core.domain.event.message.log.LogType;
import cloud.tteams.share.core.domain.service.ILogService;
import jakarta.annotation.Nullable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class LogProducerService implements ILogService {

    private static final Log internalLogger = LogFactory.getLog(LogProducerService.class);

    private static final Log appLogger = LogFactory.getLog("TTeamsCentralizedLog");

    private final KafkaTemplate<String, Event> producer;
    private final String kafkaTopic = "log-topic";

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    public LogProducerService(KafkaTemplate<String, Event> producer) {
        this.producer = producer;
    }


    @Override
    public void log(LogType type, String message, Object data) {
        LogDataMessage logData = createLogDataMessage(type, message, data, null);
        processLog(logData, null);
    }

    @Override
    public void info(String message, Object data) {
        LogDataMessage logData = createLogDataMessage(LogType.INFO, message, data, null);
        processLog(logData, null);
    }

    @Override
    public void error(String message, Object data) {
        error(message, data, null);
    }

    @Override
    public void error(String message, Object data, @Nullable Throwable t) {
        LogDataMessage logData = createLogDataMessage(LogType.ERROR, message, data, t);
        processLog(logData, t);
    }

    private LogDataMessage createLogDataMessage(LogType type, String message, Object data, @Nullable Throwable t) {
        UserSession session = UserContext.getUserSession();
        String username = (session != null) ? session.getUsername() : "system/unknown";
        String userRole = (session != null) ? session.getUserRole() : "N/A";
        String methodName = getCallerMethodName();
        Map<String, Object> additionalData = new HashMap<>();
        if (data != null) { additionalData.put("data", data); }
        if (t != null) {
            additionalData.put("errorMessage", t.getMessage());
            additionalData.put("errorStackTrace", formatStackTrace(t));
        }
        return new LogDataMessage( UUID.randomUUID(), type, message, this.serviceName, methodName, username, userRole, LocalDateTime.now(), additionalData.isEmpty() ? null : additionalData );
    }


    private void processLog(LogDataMessage logData, @Nullable Throwable t) {
        try {
            populateMDC(logData);

            switch (logData.getType()) {
                case ERROR: appLogger.error(logData.getMessage(), t); break;
                case WARN: appLogger.warn(logData.getMessage()); break;
                case DEBUG: appLogger.debug(logData.getMessage()); break;
                case TRACE: appLogger.trace(logData.getMessage()); break;
                case INFO: default: appLogger.info(logData.getMessage()); break;
            }
            sendMessage(logData);
        } catch (Exception e) {
            internalLogger.error("Unexpected error in processLog. LogData ID: " + safeToString(logData.getId()), e);
        } finally {
            clearMDCKeys(logData);
        }
    }

    private void populateMDC(LogDataMessage logData) {
        MDC.put("log_id", safeToString(logData.getId()));
        MDC.put("log_type", safeToString(logData.getType()));
        MDC.put("log_serviceName", logData.getServiceName());
        MDC.put("log_methodName", logData.getMethodName());
        MDC.put("log_user", logData.getUser());
        MDC.put("log_userRole", logData.getUserRole());
        if (logData.getAdditionalData() != null) {
            logData.getAdditionalData().forEach((key, value)
                    -> MDC.put("log_add_data_" + key, safeToString(value)));
        }
    }

    private void clearMDCKeys(LogDataMessage logData) {
        MDC.remove("log_id");
        MDC.remove("log_type");
        MDC.remove("log_serviceName");
        MDC.remove("log_methodName");
        MDC.remove("log_user");
        MDC.remove("log_userRole");
        if (logData.getAdditionalData() != null) {
            logData.getAdditionalData().keySet().forEach(key -> MDC.remove("log_add_data_" + key));
        }
    }

    private void sendMessage(LogDataMessage logData) {
        Event logEvent = new Event(EventType.LOG, logData);
        try {
            CompletableFuture<SendResult<String, Event>> future = producer.send(kafkaTopic, logEvent);
            future.whenComplete((result, ex) -> {
                if (ex != null) {
                    internalLogger.error(String.format("Error sending LogEvent to Kafka (ID: %s). Topic: %s. Error: %s",
                            safeToString(logData.getId()), kafkaTopic, ex.getMessage()), ex);
                } else {
                    if (internalLogger.isTraceEnabled()) {
                        internalLogger.trace(String.format("LogEvent sent to Kafka (ID: %s). Topic: %s, Partition: %d, Offset: %d",
                                safeToString(logData.getId()),
                                result.getRecordMetadata().topic(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset()));
                    }
                }
            });

        } catch (Exception e) {
            internalLogger.error(String.format("Synchronous exception while trying to send LogEvent to Kafka (ID: %s). Topic: %s. Error: %s",
                    safeToString(logData.getId()), kafkaTopic, e.getMessage()), e);
        }
    }

    private String getCallerMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int callerIndex = 5;
        if (stackTrace.length > callerIndex) {
            return stackTrace[callerIndex].getMethodName();
        } else {
            return "unknown_method";
        }
    }

    private String safeToString(Object obj) {
        return obj != null ? obj.toString() : null;
    }

    private String formatStackTrace(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Throwable cause = throwable;
        int depth = 0;
        while (cause != null && depth < 15) {
            cause.printStackTrace(pw);
            cause = cause.getCause();
            if (cause != null && depth < 15 -1) {
                pw.println("Caused by:");
            }
            depth++;
        }
        pw.flush();
        return sw.toString();
    }

}
