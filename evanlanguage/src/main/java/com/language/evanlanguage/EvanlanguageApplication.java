package com.language.evanlanguage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.language.*")
@EntityScan(basePackages = "com.language.*")
@EnableJpaRepositories(basePackages = "com.language.*")
public class EvanlanguageApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvanlanguageApplication.class, args);
    }
}
