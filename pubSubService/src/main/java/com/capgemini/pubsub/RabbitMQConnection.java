package com.capgemini.pubsub;

/**
 * This will provide Rabbit MQ connection and configuration.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitMQConnection {

	/**
	 * Will provide host for RabbitMQ
	 */
	@Value("${spring.rabbitmq.host}")
	private String host;
	/**
	 * Will provide port for RabbitMQ
	 */
	@Value("${spring.rabbitmq.port}")
	private String port;
	/**
	 * Will provide user Name for RabbitMQ
	 */
	@Value("${spring.rabbitmq.username}")
	private String userName;
	/**
	 * Will provide password for RabbitMQ
	 */
	@Value("${spring.rabbitmq.password}")
	private String password;

	/**
	 * This will provide Connection Factory
	 * 
	 * @return
	 */
	@Bean
	public ConnectionFactory createConnectionFactory() {
		ConnectionFactory cf = new ConnectionFactory();
		cf.setHost(host);
		cf.setPort(Integer.parseInt(port));
		cf.setUsername(userName);
		cf.setPassword(password);
		return cf;

	}
}
