package com.walmart.orderhist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.orderhist.dto.CartResponse;
import com.walmart.orderhist.dto.OrderHistResponse;
import com.walmart.orderhist.dto.OrderResponse;
import com.walmart.orderhist.exception.CartNotFoundException;
import com.walmart.orderhist.exception.CartServiceException;
import com.walmart.orderhist.exception.InvalidCartException;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.OrderServiceException;
import com.walmart.orderhist.feign.CartFeignClient;
import com.walmart.orderhist.feign.OrderFeignClient;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderHistServiceImpl implements OrderHistService {

	private final OrderFeignClient orderFeignClient;
	private final CartFeignClient cartFeignClient;

	@Autowired
	public OrderHistServiceImpl(CartFeignClient cartFeignClient, OrderFeignClient orderFeignClient) {

		this.cartFeignClient = cartFeignClient;
		this.orderFeignClient = orderFeignClient;
	}

	public OrderHistResponse getOrderHistory(String userId) throws OrderNotFoundException, CartServiceException,
			OrderServiceException, CartNotFoundException, InvalidCartException {

		CartResponse cartResponse = getCartResponse(userId);
		OrderResponse orderResponse = getOrderResponse(userId);

		if (cartResponse.getCartId().equals(orderResponse.getCartId())) {
			log.info("Order histroy Success for this userId : {}", userId);

			return maptoOrderHistResponse(cartResponse, orderResponse);

		} else {
			log.info("Cart ID mismatch between cart and order for user with ID: {}", userId);
			throw new InvalidCartException("Cart ID mismatch between cart and order for user with ID: " + userId);
		}

	}

	public CartResponse getCartResponse(String userId) throws CartServiceException, CartNotFoundException {
		try {

			CartResponse cartResponse = cartFeignClient.getCartDetails(userId);

			if (cartResponse == null) {
				// Assuming CartNotFoundException is a custom exception class
				log.info("Cart not found for user with ID: {}", userId);
				throw new CartNotFoundException("Cart not found for user with ID: " + userId);
			}

			return cartResponse;
		} catch (FeignException e) {
			log.error("Cart Service is down for this user Id : {}", userId);
			throw new CartServiceException("Cart Service is down for this user Id :" + userId);
		}

	}

	public OrderResponse getOrderResponse(String userId) throws OrderNotFoundException, OrderServiceException {
		try {
			OrderResponse orderResponse = orderFeignClient.getOrderDetails(userId);

			if (orderResponse == null) {
				log.info("Order not found for user with ID:{} ", userId);
				throw new OrderNotFoundException("Order not found for user with ID: " + userId);
			}

			return orderResponse;
		} catch (FeignException e) {
			log.error("Order Service is down for this user Id : {}", userId);
			throw new OrderServiceException("Order Service is down for this user Id :" + userId);
		}
	}

	public OrderHistResponse maptoOrderHistResponse(CartResponse cartResponse, OrderResponse orderResponse) {

		OrderHistResponse orderHistResponse = new OrderHistResponse();
		// Map OrderHistResponse from both CartResponse and OrderResponses
		orderHistResponse.setOrderId(orderResponse.getOrderId());
		orderHistResponse.setDateOfOrder(orderResponse.getDateOfOrder());
		orderHistResponse.setAmount(orderResponse.getAmount());
		orderHistResponse.setModeOfPayment(orderResponse.getModeOfPayment());
		orderHistResponse.setPaymentStatus(orderResponse.getPaymentStatus());
		orderHistResponse.setDateOfDelivery(orderResponse.getDateOfDelivery());
		orderHistResponse.setStatusOfOrder(orderResponse.getStatusOfOrder());
		orderHistResponse.setProducts(cartResponse.getProducts());
		return orderHistResponse;

	}

}
