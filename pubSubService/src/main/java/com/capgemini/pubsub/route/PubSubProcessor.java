package com.capgemini.pubsub.route;

/**
 * @author bdeshpan
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.capgemini.pubsub.model.PublishAlert;
import com.capgemini.pubsub.model.Response;
import com.capgemini.pubsub.model.ResponseErrors;



@Component
public class PubSubProcessor {

	@Produce(uri = "direct:startMQPoint")
	private ProducerTemplate template;

	@Value("${yerba.routing.Key}")
	private String yerbaroutingKey;

	@Value("${other.routing.Key}")
	private String otherroutingKey;

	@Value("${other.queue}")
	private String otherqueue;

	@Value("${yerba.queue}")
	private String yerbaqueue;
	
	@Value("${search.clientId}")
	private String searchCustomer;
	
	/**
	 * process monitoring Message
	 * 
	 * @param request
	 * @param alert
	 * @throws Exception
	 */
	protected ResponseEntity<Response> processAlert(HttpServletRequest request, PublishAlert alert) throws Exception {
		Map<String, Object> headers = new HashMap<>();
		if (alert.getIsSubscriptionOn()) {
			headers.put("routingKey", (alert.getCustomerID().contains(searchCustomer) ? yerbaroutingKey : otherroutingKey));
			headers.put("queue", (alert.getCustomerID().contains(searchCustomer) ? yerbaqueue : otherqueue));
			template.asyncRequestBodyAndHeaders(template.getDefaultEndpoint(), alert,
					Collections.<String, Object>unmodifiableMap(headers));
			System.out.println("Reached to Publisher API" + alert.toString());
			return new ResponseEntity<Response>(
					createResponse("Alert Payload Recieved for Publishing", Collections.emptyList()), HttpStatus.ACCEPTED);
		} else {
			System.out.println("Not allowed to Publish message Subscription is OFF for " + alert.getCustomerID());
			return new ResponseEntity<Response>(createResponse("Now allowed to Publish message.", Collections.emptyList()), HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Will create custom response message
	 * 
	 * @param message
	 * @param errors
	 * @return Response
	 */
	public Response createResponse(String message, List<String> errors) {
		Response response = new Response();
		response.setMessage(message);
		ResponseErrors responseError;
		for (String error : errors) {
			responseError = new ResponseErrors();
			responseError.setError(error);
			response.addErrorsItem(responseError);
		}
		return response;
	}
}
