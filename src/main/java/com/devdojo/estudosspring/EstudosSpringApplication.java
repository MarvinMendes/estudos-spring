package com.devdojo.estudosspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EstudosSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudosSpringApplication.class, args);
    }

}
