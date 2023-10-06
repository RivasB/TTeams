package cloud.tteams.station.station.infrastructure.service;

import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GeoDistanceService {

    public StationDto findClosestObject(Set<StationDto> stationDtos, double targetLatitude, double targetLongitude) {
        StationDto closestObject = null;
        double closestDistance = Double.MAX_VALUE;
        for (StationDto obj : stationDtos) {
            double objLatitude = Double.parseDouble(obj.getLocation().getLatitude());
            double objLongitude = Double.parseDouble(obj.getLocation().getLongitude());
            double distance = calculateDistance(targetLatitude, targetLongitude, objLatitude, objLongitude);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestObject = obj;
            }
        }
        return closestObject;
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
