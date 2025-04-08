package com.sercanozbek.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.sercanozbek"})
@ComponentScan(basePackages = {"com.sercanozbek"})
@EnableJpaRepositories(basePackages = {"com.sercanozbek"})
@SpringBootApplication
@PropertySource(value = "classpath:app.properties")
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}
