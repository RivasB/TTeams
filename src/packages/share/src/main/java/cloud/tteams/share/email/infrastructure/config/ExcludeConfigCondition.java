package cloud.tteams.share.email.infrastructure.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ExcludeConfigCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String excludeConfig = context.getEnvironment().getProperty("spring.mail.active");
        return excludeConfig == null || !excludeConfig.equalsIgnoreCase("false");
    }
}
