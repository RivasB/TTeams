package cloud.tteams.project.shared.infrastructure.config;

import cloud.tteams.project.project.infrastructure.adapter.query.ProjectQueryRepositoryImplementation;
import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
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
@SuppressWarnings("all")
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "readEntityManagerFactory", transactionManagerRef =
        "readTransactionManager", basePackageClasses = {ProjectQueryRepositoryImplementation.class})
public class DatabaseReadConfiguration {

    @Bean(name = "readDataSourceProperties")
    @ConfigurationProperties(value = "spring.read-datasource")
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
                .packages(ProjectEntity.class)
                .persistenceUnit("ReadDB").build();
    }

    @Bean(name = "readTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("readEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
