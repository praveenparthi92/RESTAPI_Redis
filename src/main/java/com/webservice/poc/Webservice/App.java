package com.webservice.poc.Webservice;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mangofactory.swagger.plugin.EnableSwagger;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
//@ComponentScan(basePackages = "com.webservice")
//@EnableJpaRepositories("com.tw.repository") // To segregate MongoDB and JPA repositories. Otherwise not needed.
@EnableSwagger // auto generation of API docs
//@PropertySource({"classpath:application.properties"})
public class App extends SpringBootServletInitializer
{
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(App.class,args);
    }
}
