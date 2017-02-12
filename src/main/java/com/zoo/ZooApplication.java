package com.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * spring web mvc REST, the controller must be in the same package
 * reference: 
 * https://github.com/bkielczewski/example-spring-boot-mvc
 * https://spring.io/guides/tutorials/bookmarks/
 *
 */
public class ZooApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(ZooApplication.class, args);
    }
}