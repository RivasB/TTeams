package ec.gob.registrocivil.identity.shared.infrastructure.config;

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
        "ec.gob.registrocivil.identity.user.infrastructure.adapter.command",
        "ec.gob.registrocivil.identity.agency.infrastructure.adapter.command",
        "ec.gob.registrocivil.identity.access.infrastructure.adapter.command",
        "ec.gob.registrocivil.identity.profile.infrastructure.adapter.command",
        "ec.gob.registrocivil.identity.aplication.infrastructure.adapter.command",
        "ec.gob.registrocivil.identity.geographiclocation.infrastructure.adapter.command",
        "ec.gob.registrocivil.identity.telephone_operator.infrastructure.adapter.command",
        "ec.gob.registrocivil.identity.validation_mesh.infrastructure.adapter.command" })
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
                .packages("ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate",
                        "ec.gob.registrocivil.identity.agency.infrastructure.repository.hibernate",
                        "ec.gob.registrocivil.identity.access.infrastructure.repository.hibernate",
                        "ec.gob.registrocivil.identity.profile.infrastructure.repository.hibernate",
                        "ec.gob.registrocivil.identity.aplication.infrastructure.repository.hibernate",
                        "ec.gob.registrocivil.identity.geographiclocation.infrastructure.repository.hibernate",
                        "ec.gob.registrocivil.identity.telephone_operator.infrastructure.repository.hibernate",
                        "ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate")
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
