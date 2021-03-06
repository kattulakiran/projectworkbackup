package com.vims.rs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
@Configuration
@ComponentScan
@EnableAutoConfiguration
*/
@SpringBootApplication
@EnableJpaRepositories 

public class Application {//extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }
   
    private static Class<Application> applicationClass = Application.class;
}



