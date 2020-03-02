package com.capgemini.pubsub.controller;

/**
 * Will provide API for publishing message to RabbitMQ
 * @author bdeshpan
 */
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pubsub.model.PublishAlert;
import com.capgemini.pubsub.model.Response;
import com.capgemini.pubsub.route.PubSubProcessor;

@RestController
public class PubSubController extends PubSubProcessor {
	
	/**
	 * Will return health check for alert Service.
	 * 
	 * @param request
	 * @return response for system availability.
	 * @throws Exception
	 */
	@GetMapping(path = "/healthCheck")
	public ResponseEntity<Response> healthCheack(HttpServletRequest request) throws Exception {

		return new ResponseEntity<Response>(createResponse("OK", Collections.emptyList()), HttpStatus.OK);
	}

	/**
	 * Will publish monitoring message to Rabbit MQ
	 * @param request
	 * @param alert
	 * @return Acceptance message
	 * @throws Exception
	 */
	@PostMapping(path = "/publishAlert")
	public ResponseEntity<Response> createAlert(HttpServletRequest request, @RequestBody PublishAlert alert)
			throws Exception {
		return processAlert(request, alert);
	}

}
