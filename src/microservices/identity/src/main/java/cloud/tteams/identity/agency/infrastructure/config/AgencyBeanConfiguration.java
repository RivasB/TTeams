package cloud.tteams.identity.agency.infrastructure.config;

import cloud.tteams.identity.IdentityApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class AgencyBeanConfiguration {

}
