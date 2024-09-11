package cloud.tteams.identity.user.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cloud.tteams.identity.IdentityApplication;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class UserBeanConfiguration {

    @Bean
    public BCryptPasswordEncoder beanPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
