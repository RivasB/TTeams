package cloud.tteams.share.core.domain.event.message.log;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class LogEvent extends Event {
    public LogEvent(EventType type, Object data) {
        super(type, data);
    }
}
