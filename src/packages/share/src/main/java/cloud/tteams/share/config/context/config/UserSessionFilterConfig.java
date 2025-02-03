package cloud.tteams.share.config.context.config;

import cloud.tteams.share.config.context.filter.UserSessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserSessionFilterConfig {

    @Bean
    public FilterRegistrationBean<UserSessionFilter> userSessionFilterBean() {
        FilterRegistrationBean<UserSessionFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserSessionFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
