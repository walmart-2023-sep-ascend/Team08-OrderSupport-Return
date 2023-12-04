package com.walmart.orderhist.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.walmart.orderhist.service.*;

import com.walmart.orderhist.dto.OrderResponse;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class OrderFeignClientFallback implements OrderFeignClient {

	private static final Logger log = LoggerFactory.getLogger(OrderHistServiceImpl.class);
	
	@Override
	public OrderResponse getOrderDetails(String userId) {
		log.info("Orderfallback: order service is down for this userId : {}", userId);
		return null;
	}

}
