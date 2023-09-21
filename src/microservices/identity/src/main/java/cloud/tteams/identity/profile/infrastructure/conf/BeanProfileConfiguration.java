package cloud.tteams.identity.profile.infrastructure.conf;

import cloud.tteams.identity.IdentityApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class BeanProfileConfiguration {

}
