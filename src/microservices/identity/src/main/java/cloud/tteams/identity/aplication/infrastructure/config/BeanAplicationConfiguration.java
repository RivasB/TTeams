package cloud.tteams.identity.aplication.infrastructure.config;

import cloud.tteams.identity.IdentityApplication;
import cloud.tteams.identity.aplication.infrastructure.service.DomainAplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.repository.IAplicationCommandRepository;
import cloud.tteams.identity.aplication.domain.repository.IAplicationQueryRepository;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.identity.aplication.domain.service.IAplicationService;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class BeanAplicationConfiguration {

    @Bean
    IAplicationService aplicationService(final IAplicationCommandRepository commandRepository,
            final IAplicationQueryRepository queryRepository, final IEventService<Aplication> eventService) {
        return new DomainAplicationService(commandRepository, queryRepository, eventService);
    }

}
