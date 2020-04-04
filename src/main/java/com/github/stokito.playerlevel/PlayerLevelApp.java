package com.github.stokito.playerlevel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PlayerLevelApp {
    public static void main(String[] args) {
        SpringApplication.run(PlayerLevelApp.class, args);
    }
}
