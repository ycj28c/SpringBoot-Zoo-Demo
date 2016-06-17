package com.sishuok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-12-22
 * <p>Version: 1.0
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableSwagger2

/**
 * spring web mvc REST helloworld 2 mins
 *
 */
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}