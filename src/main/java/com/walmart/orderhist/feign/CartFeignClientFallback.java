package com.walmart.orderhist.feign;

import org.springframework.stereotype.Component;

import com.walmart.orderhist.dto.CartResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CartFeignClientFallback implements CartFeignClient {

	@Override
	public CartResponse getCartDetails(String userId) {
		log.info("Cartfallback: cart service is down for this userId : {}", userId);
		return null;
	}
}
