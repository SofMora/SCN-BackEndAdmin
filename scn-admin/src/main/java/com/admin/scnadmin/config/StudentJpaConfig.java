package com.admin.scnadmin.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = "com.admin.scnadmin.repository.student",
        entityManagerFactoryRef = "studentEntityManagerFactory",
        transactionManagerRef = "studentTransactionManager"
)
@EnableTransactionManagement
public class StudentJpaConfig {

    @Bean(name = "studentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("studentDataSource") DataSource sqlServerDS){

        LocalContainerEntityManagerFactoryBean localContainer = new LocalContainerEntityManagerFactoryBean();
        localContainer.setDataSource(sqlServerDS);
        localContainer.setPersistenceUnitName("SqlServerStudent");
        localContainer.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, String> additionalProps = new HashMap<>();
        additionalProps.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        localContainer.setJpaPropertyMap(additionalProps);
        localContainer.setPackagesToScan("com.admin.scnadmin.model");

        return localContainer;
    }


    @Bean(name = "studentTransactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("studentEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }

}
