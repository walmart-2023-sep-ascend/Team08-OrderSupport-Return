package com.walmart.orderhist.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmart.orderhist.dto.OrderResponse;
import com.walmart.orderhist.exception.OrderServiceException;

@Service
public class OrderAPI {

	private final RestTemplate restTemplate;

	@Autowired
	public OrderAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private static final Logger log = LoggerFactory.getLogger(OrderAPI.class);

	@Value("${capstone.orderservice.url}")
	private String orderService;

	public OrderResponse getOrderDetails(String userId) throws OrderServiceException {

		try {
			ResponseEntity<OrderResponse> response = restTemplate.exchange(orderService + userId, HttpMethod.GET, null,
					OrderResponse.class);

			if (response.getStatusCode() == HttpStatus.OK) {

				return response.getBody();
			} else {
				return null;
			}
		} catch (Exception e) {
			log.info("Order service Exception for this  userId :{}", userId + e.getMessage());

			throw new OrderServiceException("Order service down");

		}

	}
}
