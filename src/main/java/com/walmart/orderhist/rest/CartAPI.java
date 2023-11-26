package com.walmart.orderhist.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmart.orderhist.dto.CartResponse;
import com.walmart.orderhist.exception.CartServiceException;
@Service
public class CartAPI {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(CartAPI.class);

	private static final String CART_SERVICE = "https://ascend-team08.free.beeceptor.com/";
	private static final String CART_SERVICE_PATH = "cart/fetchCartDetails/user/";

	public CartResponse getCartDetails(String userId) throws CartServiceException {

		try {
			ResponseEntity<CartResponse> response = restTemplate.exchange(CART_SERVICE + CART_SERVICE_PATH + userId,
					HttpMethod.GET, null, CartResponse.class);

			if (response.getStatusCode() == HttpStatus.OK) {

				return response.getBody();
			} else {
				return null;
			}
		} catch (Exception e) {
			log.info("Cart service Exception for this  userId: {}", userId);
			e.printStackTrace();
			throw new CartServiceException("Cart service down");

		}

	}
}
