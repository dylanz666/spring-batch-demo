package com.github.dylanz666;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : dylanz
 * @since : 08/25/2020
 */
@SpringBootApplication
@EnableBatchProcessing
//@EnableScheduling
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
