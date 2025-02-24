package com.admin.scnadmin.scn_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication @ComponentScan({"com.admin.scnadmin.controller","com.admin.scnadmin.service",
        "com.admin.scnadmin.repository","com.admin.scnadmin.config"
        })
@EntityScan(basePackages = {"com.*"})
@EnableTransactionManagement
public class ScnAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScnAdminApplication.class, args);
    }

}
