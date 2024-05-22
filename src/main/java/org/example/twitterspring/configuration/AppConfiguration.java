package org.example.twitterspring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public String someBean() {
        return "Some bean";
    }
}
