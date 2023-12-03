package com.walmart.orderhist.feign;

import org.springframework.stereotype.Component;

import com.walmart.orderhist.dto.OrderResponse;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class OrderFeignClientFallback implements OrderFeignClient {

	@Override
	public OrderResponse getOrderDetails(String userId) {
		log.info("Orderfallback: order service is down for this userId : {}", userId);
		return null;
	}

}
