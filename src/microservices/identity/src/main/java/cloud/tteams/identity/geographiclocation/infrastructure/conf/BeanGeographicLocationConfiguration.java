package cloud.tteams.identity.geographiclocation.infrastructure.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cloud.tteams.identity.IdentityApplication;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class BeanGeographicLocationConfiguration {

}
