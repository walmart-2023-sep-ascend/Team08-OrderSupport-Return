package com.walmart.orderhist.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walmart.orderhist.dto.OrderResponse;
import com.walmart.orderhist.exception.OrderServiceException;

@FeignClient(name = "order-service", url = "https://ascend-team08.free.beeceptor1.com/order")
public interface OrderFeignClient {

	@GetMapping("{userId}")
	OrderResponse getOrderDetails(@PathVariable String userId);

}
