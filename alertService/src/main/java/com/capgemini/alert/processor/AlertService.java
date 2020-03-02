package com.capgemini.alert.processor;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.alert.model.Alert;
import com.capgemini.alert.model.CreateResponse;
import com.capgemini.alert.model.Response;

@Service
public class AlertService {

	@Produce
	private ProducerTemplate template;

	protected ResponseEntity<Response> processAlert(HttpServletRequest request, Alert alert) throws Exception {

		template.asyncRequestBodyAndHeaders("direct:forwardAlert", alert, null);

		return new ResponseEntity<Response>(
				CreateResponse.createResponse("Alert Payload Recieved for Creation", Collections.emptyList()),
				HttpStatus.ACCEPTED);

	}

}
