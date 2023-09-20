package ec.gob.registrocivil.identity.profile.infrastructure.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ec.gob.registrocivil.identity.IdentityApplication;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class BeanProfileConfiguration {

}
