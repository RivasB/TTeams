package ec.gob.registrocivil.identity.telephone_operator.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ec.gob.registrocivil.identity.IdentityApplication;
import ec.gob.registrocivil.share.core.domain.service.IEventService;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;
import ec.gob.registrocivil.identity.telephone_operator.domain.repository.ITelephoneOperatorCommandRepository;
import ec.gob.registrocivil.identity.telephone_operator.domain.repository.ITelephoneOperatorQueryRepository;
import ec.gob.registrocivil.identity.telephone_operator.domain.service.ITelephoneOperatorService;
import ec.gob.registrocivil.identity.telephone_operator.infrastructure.service.DomainTelephoneOperatorService;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class TelephoneOperatorBeanConfiguration {

    @Bean
    ITelephoneOperatorService telephoneOperatorService(
            ITelephoneOperatorCommandRepository commandRepository,
            ITelephoneOperatorQueryRepository queryRepository,
            IEventService<TelephoneOperator> eventService) {

        return new DomainTelephoneOperatorService(commandRepository, queryRepository, eventService);
    }
}
