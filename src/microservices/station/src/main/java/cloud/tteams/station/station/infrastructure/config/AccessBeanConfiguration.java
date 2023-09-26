package cloud.tteams.identity.access.infrastructure.config;

import cloud.tteams.identity.access.infrastructure.service.DomainAccessService;
import cloud.tteams.identity.StationApplication;
import cloud.tteams.identity.access.domain.repository.IStationQueryRepository;
import cloud.tteams.identity.access.domain.service.IStationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = StationApplication.class)
public class AccessBeanConfiguration {

    @Bean
    IStationService accessService(final IStationQueryRepository queryRepository) {

        return new DomainAccessService(queryRepository);
    }
}
