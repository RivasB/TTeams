package cloud.tteams.station.chargingpoint.infrastructure.exception;

public class ChargingPointNotFound extends RuntimeException{
    public ChargingPointNotFound() {
        super("Charging Point not found!");
    }
}
