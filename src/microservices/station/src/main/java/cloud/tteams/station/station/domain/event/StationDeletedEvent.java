package cloud.tteams.station.station.domain.event;


import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.station.station.domain.Station;

public class StationDeletedEvent extends Event<Station> {

    public StationDeletedEvent(Station data) {
        super(EventType.DELETED, data);
    }

}
