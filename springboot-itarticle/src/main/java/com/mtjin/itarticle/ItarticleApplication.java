package com.mtjin.itarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ItarticleApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ItarticleApplication.class);
        app.run(args);
    }

}
