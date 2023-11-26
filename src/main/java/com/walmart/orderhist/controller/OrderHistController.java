package com.walmart.orderhist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.orderhist.dto.OrderHistResponse;
import com.walmart.orderhist.exception.CartNotFoundException;
import com.walmart.orderhist.exception.CartServiceException;
import com.walmart.orderhist.exception.InvalidCartException;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.OrderServiceException;
import com.walmart.orderhist.exception.UserNotFoundException;
import com.walmart.orderhist.service.OrderHistServiceImpl;

@RestController

//@Api(tags = "OrderHistController", description = "Order history Controller Details")
public class OrderHistController {

	@Autowired
	private OrderHistServiceImpl orderHistServiceImpl;

	@GetMapping("/welcome")
	public String healthCheck() {
		return "service is up";
	}

	@GetMapping("/order/history/{userId}")
	public ResponseEntity<OrderHistResponse> getOrderHist(@PathVariable @NonNull String userId)
			throws UserNotFoundException, OrderNotFoundException, CartServiceException, OrderServiceException,
			CartNotFoundException, InvalidCartException {

		return ResponseEntity.ok(orderHistServiceImpl.getOrderHistory(userId));

	}

}
