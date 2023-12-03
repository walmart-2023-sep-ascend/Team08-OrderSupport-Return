package com.walmart.orderhist.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walmart.orderhist.dto.OrderResponse;

@FeignClient(name = "order-service", url = "${capstone.orderservice.url}",fallback = OrderFeignClientFallback.class)
public interface OrderFeignClient {

	@GetMapping("{userId}")
	OrderResponse getOrderDetails(@PathVariable String userId);

}

