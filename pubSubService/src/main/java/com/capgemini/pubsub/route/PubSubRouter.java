package com.capgemini.pubsub.route;
/**
 * @author bdeshpan
 */
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

/**
 * Will publish message to Rabbit MQ
 * @author bdeshpan
 *
 */
@Component
public class PubSubRouter extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("direct:startMQPoint")
		.routeId("startMQPointOther")
		.marshal()
		.json(JsonLibrary.Jackson)
		.toD("rabbitmq:{{exchangeKey}}?exchangeType=topic&autoDelete=false&routingKey=${header.routingKey}&queue=${header.queue}")
		.end();
	}
}
