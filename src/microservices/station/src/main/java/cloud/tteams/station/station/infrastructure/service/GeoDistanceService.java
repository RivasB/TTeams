package cloud.tteams.station.station.infrastructure.service;

import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;

@Service
public class GeoDistanceService {

    public StationDto findClosestObject(Set<StationDto> stationDtos, double targetLatitude, double targetLongitude) {
        return stationDtos.stream()
                .min(Comparator.comparingDouble(obj -> calculateDistance(targetLatitude, targetLongitude,
                        Double.parseDouble(obj.getLocation().getLatitude()),
                        Double.parseDouble(obj.getLocation().getLongitude()))))
                .orElse(null);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
