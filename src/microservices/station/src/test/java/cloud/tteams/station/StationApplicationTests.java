package cloud.tteams.station;

import cloud.tteams.station.chargingpoint.infrastructure.service.DomainChargingPointServiceTest;
import cloud.tteams.station.location.infrastructure.service.DomainLocationServiceTest;
import cloud.tteams.station.station.infrastructure.service.DomainStationServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({DomainStationServiceTest.class, DomainLocationServiceTest.class,
        DomainChargingPointServiceTest.class})
@SpringBootTest
public class StationApplicationTests {
}
