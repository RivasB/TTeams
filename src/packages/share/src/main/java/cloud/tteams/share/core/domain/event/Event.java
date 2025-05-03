package cloud.tteams.share.core.domain.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;
import java.util.UUID;

public class Event{

    private String id;

    private Date date;

    private EventType type;

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
    private Object data;

    public Event(EventType type, Object data) {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
        this.type = type;
        this.data = data;
    }

    public Event(String id, Date date, EventType type, Object data) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.data = data;
    }

    public Event() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
