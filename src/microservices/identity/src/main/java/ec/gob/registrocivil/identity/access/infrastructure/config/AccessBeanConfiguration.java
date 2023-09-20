package ec.gob.registrocivil.identity.access.infrastructure.config;

import ec.gob.registrocivil.identity.IdentityApplication;
import ec.gob.registrocivil.identity.access.domain.repository.IAccessQueryRepository;
import ec.gob.registrocivil.identity.access.domain.service.IAccessService;
import ec.gob.registrocivil.identity.access.infrastructure.service.DomainAccessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class AccessBeanConfiguration {

    @Bean
    IAccessService accessService(final IAccessQueryRepository queryRepository) {

        return new DomainAccessService(queryRepository);
    }
}
