package cloud.tteams.station.station.domain.event;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class StationCreatedEvent extends Event<Station> {

    public StationCreatedEvent(Station data) {
        super(EventType.CREATED, data);
    }

}
