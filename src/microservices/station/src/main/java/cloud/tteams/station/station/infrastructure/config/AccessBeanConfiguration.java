package cloud.tteams.station.station.infrastructure.config;


import cloud.tteams.identity.StationApplication;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.domain.service.IStationService;
import cloud.tteams.station.station.infrastructure.service.DomainStationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = StationApplication.class)
public class AccessBeanConfiguration {

    @Bean
    IStationService accessService(final IStationQueryRepository queryRepository) {

        return new DomainStationService(queryRepository);
    }
}
