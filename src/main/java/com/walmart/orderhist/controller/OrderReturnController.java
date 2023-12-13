package com.walmart.orderhist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.walmart.orderhist.dto.OrderReturnResponse;
import com.walmart.orderhist.dto.ReturnRequest;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;
import com.walmart.orderhist.service.OrderReturnService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderReturnController {
	@GetMapping("/welcomeToReturn")
	public String healthCheck() {
		return "service is up";
	}
	@Autowired
	OrderReturnService orderReturnService;
	
	@PostMapping("/returns")
	public ResponseEntity<OrderReturnResponse> orderReturn(@RequestBody ReturnRequest returnRequest) {
		ResponseEntity<OrderReturnResponse> orderReturnInfo;
		try {
			orderReturnInfo = orderReturnService.orderReturn(returnRequest.getOrderId(),returnRequest.getReason());
			
			System.out.println(orderReturnInfo);
			return orderReturnInfo;
		} catch (ExternalReturnNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
}
