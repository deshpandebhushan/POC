package com.capgemini.ec.alert;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.capgemini.alert.controller.AlertController;
import com.capgemini.alert.model.Response;

@RunWith(MockitoJUnitRunner.class)
class AlertServiceControllerTests {

	@Mock
	private AlertController ac;
	@Mock
	private HttpServletRequest request;
	
	@Test
	public void TestHelathCheck() throws Exception {
		ResponseEntity<Response> response = ac.healthCheack(request);
		Assert.assertNotNull(response);
		response.getBody();
	}

}
