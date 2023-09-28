package cloud.tteams.station.station.infrastructure.exception;

public class StationNotFoundException extends RuntimeException {

    public StationNotFoundException() {
        super("Access not found!");
    }

    public StationNotFoundException(String message) {
        super(message);
    }
}
