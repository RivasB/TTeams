package cloud.tteams.share.core.domain.event;

import cloud.tteams.share.core.domain.notification.Notification;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;
import java.util.UUID;

public abstract class Event{

    private String id;

    private Date date;

    private EventType type;

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
    private Notification data;

    protected Event(EventType type, Notification data) {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
        this.type = type;
        this.data = data;
    }

    public Event(String id, Date date, EventType type, Notification data) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.data = data;
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

    public Notification getData() {
        return data;
    }

    public void setData(Notification data) {
        this.data = data;
    }
}
