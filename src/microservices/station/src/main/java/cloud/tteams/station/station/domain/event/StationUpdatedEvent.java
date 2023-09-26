package cloud.tteams.station.station.domain.event;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class StationUpdatedEvent extends Event<Station> {

    public StationUpdatedEvent(Station data) {
        super(EventType.UPDATED, data);
    }

}
