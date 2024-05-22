package org.example.twitterspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TwitterSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterSpringApplication.class, args);
    }

}
