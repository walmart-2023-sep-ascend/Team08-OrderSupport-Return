package com.walmart.orderhist.service;

import org.springframework.http.ResponseEntity;

import com.walmart.orderhist.dto.CartResponse;
import com.walmart.orderhist.dto.OrderHistResponse;
import com.walmart.orderhist.dto.OrderResponse;
import com.walmart.orderhist.exception.CartNotFoundException;
import com.walmart.orderhist.exception.CartServiceException;
import com.walmart.orderhist.exception.InvalidCartException;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.OrderServiceException;
import com.walmart.orderhist.exception.UserNotFoundException;

public interface OrderHistService {

	public OrderHistResponse getOrderHistory(String userId) throws OrderNotFoundException, CartServiceException,
	OrderServiceException, CartNotFoundException, InvalidCartException;

	public OrderHistResponse MaptoOrderHistResponse(CartResponse cartResponse, OrderResponse orderResponse);
	public OrderResponse getOrderResponse(String userId) throws OrderNotFoundException, OrderServiceException;
	public CartResponse getCartResponse(String userId) throws CartServiceException, CartNotFoundException;

}
