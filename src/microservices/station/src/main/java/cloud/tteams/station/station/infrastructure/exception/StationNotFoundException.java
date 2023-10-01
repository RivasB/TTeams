package cloud.tteams.station.station.infrastructure.exception;

public class StationNotFoundException extends RuntimeException {

    public StationNotFoundException() {
        super("Station not found!");
    }

}
