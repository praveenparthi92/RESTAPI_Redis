package com.webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
/*@EnableAutoConfiguration*/  // Sprint Boot Auto Configuration
//@ComponentScan(basePackages = "com.webservice")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
