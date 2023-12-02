package com.walmart.orderhist.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walmart.orderhist.dto.CartResponse;

@FeignClient(name = "cart-service", url = "https://ascend-team08.free.beeceptor.com/cart", fallback = CartFeignClientFallback.class)
public interface CartFeignClient {

	@GetMapping("/fetchCartDetails/user/{userId}")
	CartResponse getCartDetails(@PathVariable String userId);
}
