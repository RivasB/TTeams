package cloud.tteams.station.station.domain.event;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class StationDeletedEvent extends Event<Station> {

    public StationDeletedEvent(Station data) {
        super(EventType.DELETED, data);
    }

}
