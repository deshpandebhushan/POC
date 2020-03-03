package com.capgemini.alert.controller;

/**
 *  Will receive alert generated by monitoring tool.
 */
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.alert.model.Alert;
import com.capgemini.alert.model.CreateResponse;
import com.capgemini.alert.model.Response;
import com.capgemini.alert.processor.AlertService;

@RestController
@RequestMapping("/alert")
public class AlertController extends AlertService {
	
	/**
	 * Will return health check for alert Service.
	 * @param request
	 * @return response for system availability.
	 * @throws Exception
	 */
	@GetMapping(path = "/healthCheck")
	public ResponseEntity<Response> healthCheack(HttpServletRequest request) throws Exception {

		return new ResponseEntity<Response>(CreateResponse.createResponse("OK", Collections.emptyList()),
				HttpStatus.OK);
	}

	/**
	 * Will accept message to process alert.
	 * @param request
	 * @param alert
	 * @return Acceptance response.
	 * @throws Exception
	 */
	@PostMapping(path = "/createAlert")
	public ResponseEntity<Response> createAlert(HttpServletRequest request, @RequestBody Alert alert) throws Exception {
		return processAlert(request, alert);
	}

}