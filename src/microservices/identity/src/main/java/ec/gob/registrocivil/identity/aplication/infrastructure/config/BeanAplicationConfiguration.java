package ec.gob.registrocivil.identity.aplication.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ec.gob.registrocivil.identity.IdentityApplication;
import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.repository.IAplicationCommandRepository;
import ec.gob.registrocivil.identity.aplication.domain.repository.IAplicationQueryRepository;
import ec.gob.registrocivil.identity.aplication.infrastructure.service.DomainAplicationService;
import ec.gob.registrocivil.share.core.domain.service.IEventService;
import ec.gob.registrocivil.identity.aplication.domain.service.IAplicationService;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class BeanAplicationConfiguration {

    @Bean
    IAplicationService aplicationService(final IAplicationCommandRepository commandRepository,
            final IAplicationQueryRepository queryRepository, final IEventService<Aplication> eventService) {
        return new DomainAplicationService(commandRepository, queryRepository, eventService);
    }

}
