package com.admin.scnadmin.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



@Configuration
@EnableJpaRepositories(
        basePackages = "com.admin.scnadmin.repository.admin",
        entityManagerFactoryRef = "adminEntityManagerFactory",
        transactionManagerRef = "adminTransactionManager"
)
@EnableTransactionManagement
public class SqlServerJpaConfig {

    @Primary
    @Bean(name = "adminEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("adminDataSource") DataSource sqlServerDS){

        LocalContainerEntityManagerFactoryBean localContainer = new LocalContainerEntityManagerFactoryBean();
        localContainer.setDataSource(sqlServerDS);
        localContainer.setPersistenceUnitName("SqlServerAdmin");
        localContainer.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, String> additionalProps = new HashMap<>();
        additionalProps.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        localContainer.setJpaPropertyMap(additionalProps);
        localContainer.setPackagesToScan("com.admin.scnadmin.model");

        return localContainer;
    }

    @Primary
    @Bean(name = "adminTransactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("adminEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }
}
