package com.capgemini.itsm.proxy;

/**
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ItsmProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsmProxyApplication.class, args);
	}

}
