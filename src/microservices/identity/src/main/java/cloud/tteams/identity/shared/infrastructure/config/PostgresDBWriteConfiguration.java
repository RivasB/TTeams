package cloud.tteams.identity.shared.infrastructure.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "writeEntityManagerFactory", transactionManagerRef = "writeTransactionManager", basePackages = {
        "cloud.tteams.identity.user.infrastructure.adapter.command",
        "cloud.tteams.identity.agency.infrastructure.adapter.command",
        "cloud.tteams.identity.access.infrastructure.adapter.command",
        "cloud.tteams.identity.profile.infrastructure.adapter.command",
        "cloud.tteams.identity.aplication.infrastructure.adapter.command",
        "cloud.tteams.identity.geographiclocation.infrastructure.adapter.command",
        "cloud.tteams.identity.telephone_operator.infrastructure.adapter.command",
        "cloud.tteams.identity.validation_mesh.infrastructure.adapter.command" })
public class PostgresDBWriteConfiguration {

    @Primary
    @Bean(name = "writeDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(@Qualifier("writeDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "writeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
            @Qualifier("writeDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("cloud.tteams.identity.user.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.agency.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.access.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.profile.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.aplication.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.geographiclocation.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.telephone_operator.infrastructure.repository.hibernate",
                        "cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate")
                .persistenceUnit("WriteDB").build();
    }

    @Primary
    @Bean(name = "writeTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("writeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
