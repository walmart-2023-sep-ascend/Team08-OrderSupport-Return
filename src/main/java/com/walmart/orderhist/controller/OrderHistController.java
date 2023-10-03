package com.walmart.orderhist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.orderhist.service.OrderHistServiceImpl;

@RestController
public class OrderHistController {
	
	@Autowired 
	private OrderHistServiceImpl orderHistServiceImpl;


	@GetMapping("/hello")
	public String healthCheck() {
		return "service is up";
	}
	
	@GetMapping("/orderhist/{userId}")
	public ResponseEntity<String> checkOrderHist(@PathVariable Integer userId ) {
		
		//ResponseEntity<String> result = 
		
	//	System.out.println("Controller" + result);
		 return orderHistServiceImpl.orderHist(userId);
		//return "success";
		
	}
	
}
