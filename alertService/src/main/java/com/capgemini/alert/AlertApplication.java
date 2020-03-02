package com.capgemini.alert;

/**
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class AlertApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertApplication.class, args);
	}

}
