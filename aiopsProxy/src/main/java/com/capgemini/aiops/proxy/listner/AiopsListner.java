package com.capgemini.aiops.proxy.listner;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AiopsListner {

	@RabbitListener(queues = "${queue.name}")
	public void recievedMessage(Message message) {
		System.out.println("Recieved Message From RabbitMQ: " + new String(message.getBody()));

	}
}
