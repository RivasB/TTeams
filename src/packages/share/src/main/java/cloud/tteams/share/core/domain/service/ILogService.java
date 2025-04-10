package cloud.tteams.share.core.domain.service;

import cloud.tteams.share.core.domain.event.message.log.LogType;
import jakarta.annotation.Nullable;
import org.springframework.scheduling.annotation.Async;

@Async
public interface ILogService {
    void log(LogType type, String message, Object data);
    void info(String message, Object data);
    void error(String message, Object data);
    void error(String message, Object data, @Nullable Throwable t);
}
