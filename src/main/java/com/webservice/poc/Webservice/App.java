package com.webservice.poc.Webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
