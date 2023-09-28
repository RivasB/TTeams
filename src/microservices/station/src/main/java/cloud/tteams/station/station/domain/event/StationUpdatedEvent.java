package cloud.tteams.station.station.domain.event;


import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.station.station.domain.Station;

public class StationUpdatedEvent extends Event<Station> {

    public StationUpdatedEvent(Station data) {
        super(EventType.UPDATED, data);
    }

}
