package com.wxs.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class DogApplication {
	
	@Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
     CommonsMultipartResolver resolver = new CommonsMultipartResolver();
     resolver.setDefaultEncoding("UTF-8");
     resolver.setResolveLazily(true);
     resolver.setMaxInMemorySize(40960);
     resolver.setMaxUploadSize(50*1024*1024);//50M 50*1024*1024
     return resolver;
 }
	
	
	public static void main(String[] args) {
		SpringApplication.run(DogApplication.class, args);
	}
}
