package com.admin.scnadmin.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean(name = "adminDataProperties")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.admin")
    public DataSourceProperties getadminDataProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "adminDataSource")
    @Primary
    public DataSource getadminDataSource(){
        return getadminDataProperties().initializeDataSourceBuilder()
                .build();
    }

    //Database Student
    @Bean(name = "studentDataProperties")
    @ConfigurationProperties(prefix = "spring.datasource.student")
    public DataSourceProperties getStudentDataProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "studentDataSource")
    public DataSource getStudentDataSource(){
        return getStudentDataProperties().initializeDataSourceBuilder()
                .build();
    }


    //Database P{rofessor
    @Bean(name = "professorDataProperties")
    @ConfigurationProperties(prefix = "spring.datasource.professor")
    public DataSourceProperties getProfessorDataProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "professorDataSource")
    public DataSource getProfessorDataSource(){
        return getProfessorDataProperties().initializeDataSourceBuilder()
                .build();
    }

    //Database AppointmentsDB
    @Bean(name = "AppointmentsDataProperties")
    @ConfigurationProperties(prefix = "spring.datasource.appointments")
    public DataSourceProperties getAppointmentsDataProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "AppointmentsDataSource")
    public DataSource getAppointmentsDataSource(){
        return getAppointmentsDataProperties().initializeDataSourceBuilder()
                .build();
    }


}
