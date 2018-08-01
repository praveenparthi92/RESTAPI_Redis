package com.webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories("com.webservice.repo")
/*@EnableAutoConfiguration*/  // Sprint Boot Auto Configuration
//@ComponentScan(basePackages = "com.webservice")
@ComponentScan(basePackages = "com.webservice")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
