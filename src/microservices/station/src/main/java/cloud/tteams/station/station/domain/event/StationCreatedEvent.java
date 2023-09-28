package cloud.tteams.station.station.domain.event;


import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.station.station.domain.Station;

public class StationCreatedEvent extends Event<Station> {

    public StationCreatedEvent(Station data) {
        super(EventType.CREATED, data);
    }

}
