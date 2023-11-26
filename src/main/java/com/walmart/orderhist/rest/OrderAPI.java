package com.walmart.orderhist.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmart.orderhist.dto.OrderResponse;
import com.walmart.orderhist.exception.OrderServiceException;
@Service
public class OrderAPI {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(OrderAPI.class);

	private static final String ORDER_SERVICE = "https://ascend-team08.free.beeceptor.com/order/";

	public OrderResponse getOrderDetails(String userId) throws OrderServiceException {

		try {
			ResponseEntity<OrderResponse> response = restTemplate.exchange(ORDER_SERVICE + userId, HttpMethod.GET, null,
					OrderResponse.class);

			if (response.getStatusCode() == HttpStatus.OK) {

				return response.getBody();
			} else {
				return null;
			}
		} catch (Exception e) {
			log.info("Order service Exception for this  userId -{}", userId);
			e.printStackTrace();
			throw new OrderServiceException("Order service down");

		}

	}
}
