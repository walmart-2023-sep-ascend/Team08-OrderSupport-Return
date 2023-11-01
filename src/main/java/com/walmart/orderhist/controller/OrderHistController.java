package com.walmart.orderhist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.UserNotFoundException;
import com.walmart.orderhist.service.OrderHistServiceImpl;

@RestController
public class OrderHistController {

	@Autowired
	private OrderHistServiceImpl orderHistServiceImpl;

	@GetMapping("/hello")
	public String healthCheck() {
		return "service is up";
	}

	@GetMapping("/order/history/{userId}")
	public ResponseEntity<String> checkOrderHist(@PathVariable @NonNull Integer userId)
			throws UserNotFoundException, OrderNotFoundException {

		return orderHistServiceImpl.orderHist(userId);
		
	}

}
