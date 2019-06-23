package com.wsiz.moviego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Klasa startowa
 */
@SpringBootApplication
@EnableFeignClients
public class MoviegoApplication {

    /**
     * Medowa do uruchomienia projektu
     * @param args parametry uruchomieniowe
     */
    public static void main(String[] args) {
        SpringApplication.run(MoviegoApplication.class, args);
    }

}
