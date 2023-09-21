package cloud.tteams.identity.telephone_operator.infrastructure.config;

import cloud.tteams.identity.telephone_operator.infrastructure.service.DomainTelephoneOperatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cloud.tteams.identity.IdentityApplication;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.repository.ITelephoneOperatorCommandRepository;
import cloud.tteams.identity.telephone_operator.domain.repository.ITelephoneOperatorQueryRepository;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;

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
