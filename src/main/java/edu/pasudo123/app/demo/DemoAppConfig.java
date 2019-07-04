package edu.pasudo123.app.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoAppConfig {

    @Bean
    public Car car(){
        return new Car();
    }

}
