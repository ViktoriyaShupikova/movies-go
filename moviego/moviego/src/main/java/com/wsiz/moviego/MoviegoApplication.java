package com.wsiz.moviego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoviegoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviegoApplication.class, args);
    }

}
