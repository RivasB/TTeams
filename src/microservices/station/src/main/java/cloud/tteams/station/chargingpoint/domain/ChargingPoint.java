package cloud.tteams.station.chargingpoint.domain;

import cloud.tteams.station.station.domain.Station;

public record ChargingPoint(ChargingPointId id, ChargingPointPowerLevel powerLevel, Station station) {
}
