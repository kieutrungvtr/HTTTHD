package com.example.cowmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.cowmanager.entity"})
@EnableJpaRepositories(basePackages = {"com.example.cowmanager.repository"})
@EnableTransactionManagement
public class CowManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CowManagerApplication.class, args);
        System.out.println("-------==== Spring Boot ====---------");
        System.out.println("  Cow Manager has been started  ");
        System.out.println("-------==== Spring Boot ====---------");
    }
}
