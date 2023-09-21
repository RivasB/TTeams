package cloud.tteams.identity.access.infrastructure.config;

import cloud.tteams.identity.access.infrastructure.service.DomainAccessService;
import cloud.tteams.identity.IdentityApplication;
import cloud.tteams.identity.access.domain.repository.IAccessQueryRepository;
import cloud.tteams.identity.access.domain.service.IAccessService;
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
