package com.wxs.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class DogApplication {
	public static void main(String[] args) {
		SpringApplication.run(DogApplication.class, args);
	}
}
