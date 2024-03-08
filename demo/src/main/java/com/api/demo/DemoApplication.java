package com.api.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.api.demo")
public class DemoApplication {


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class,args);
	}



}
