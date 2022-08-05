package com.project.zvukiznanje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ZvukIZnanjeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZvukIZnanjeApplication.class, args);
    }

}
