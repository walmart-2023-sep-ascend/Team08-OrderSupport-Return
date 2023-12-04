package com.walmart.orderhist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.walmart.orderhist.dto.OrderReturnResponse;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;
import com.walmart.orderhist.service.OrderReturnService;

@RestController
public class OrderReturnController {
	@GetMapping("/welcomeToTracker")
	public String healthCheck() {
		return "service is up";
	}
	@Autowired
	OrderReturnService orderReturnService;
	@GetMapping("/track/{orderId}/{emailId}")
	public ResponseEntity<OrderReturnResponse> orderReturn(@PathVariable String orderId, @PathVariable String emailId) {
		ResponseEntity<OrderReturnResponse> orderReturnInfo;
		try {
			orderReturnInfo = orderReturnService.orderReturn(orderId, emailId);
			System.out.println( orderReturnInfo);
			return orderReturnInfo;
		} catch (ExternalReturnNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
