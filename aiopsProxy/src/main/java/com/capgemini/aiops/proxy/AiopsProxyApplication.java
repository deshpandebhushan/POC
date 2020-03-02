package com.capgemini.aiops.proxy;

/**
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AiopsProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiopsProxyApplication.class, args);
	}

}
