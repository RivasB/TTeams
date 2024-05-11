package cloud.tteams.identity.shared.infrastructure.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "readEntityManagerFactory", transactionManagerRef = "readTransactionManager", basePackages = {
        "cloud.tteams.identity.user.infrastructure.adapter.query",
        "cloud.tteams.identity.organization.infrastructure.adapter.query",
        "cloud.tteams.identity.authorization.infrastructure.adapter.query",
        "cloud.tteams.identity.profile.infrastructure.adapter.query",
        "cloud.tteams.identity.application.infrastructure.adapter.query",
        "cloud.tteams.identity.geographiclocation.infrastructure.adapter.query",
        "cloud.tteams.identity.telephone_operator.infrastructure.adapter.query",
        "cloud.tteams.identity.validation_mesh.infrastructure.adapter.query" })
public class PostgresDBReadConfiguration {

    @Bean(name = "readDataSourceProperties")
    @ConfigurationProperties("spring.read-datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.read-datasource")
    public DataSource datasource(@Qualifier("readDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "readEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
            @Qualifier("readDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("cloud.tteams.identity.user.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.organization.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.authorization.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.profile.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.application.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.geographiclocation.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.telephone_operator.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate")
                .persistenceUnit("ReadDB").build();
    }

    @Bean(name = "readTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("readEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
