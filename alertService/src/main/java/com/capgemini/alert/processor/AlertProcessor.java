package com.capgemini.alert.processor;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;
/**
 * This will process monitoring message.
 * @author bdeshpan
 *
 */
@Component
public class AlertProcessor extends RouteBuilder {

	@Value("${pubSub.url}")
	private String pubSubUrl;

	/**
	 * This method will push monitoring message to publisher.
	 */
	@Override
	public void configure() {

		from("direct:forwardAlert")
		.routeId("forwardAlert")
		.marshal()
		.json(JsonLibrary.Jackson)
		.setHeader(Exchange.HTTP_METHOD, simple(HttpMethod.POST.name()))
		.hystrix().hystrixConfiguration()
		.circuitBreakerEnabled(true) 
		.executionTimeoutInMilliseconds(1000)
		.fallbackEnabled(true)
		.circuitBreakerSleepWindowInMilliseconds(10000)
		.end()
		.to("{{pubSub.url}}")
		.onFallback()
		.to("direct:callerApiTimeout")
		.end();

		from("direct:callerApiTimeout").process(exchange -> {
				 throw new HystrixTimeoutException();
		}).end();

	}

}
