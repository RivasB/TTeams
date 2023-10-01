package cloud.tteams.station.location.infrastructure.exception;

public class LocationNotFoundException extends RuntimeException{

    public LocationNotFoundException() {
        super("Location not found!");
    }
}
