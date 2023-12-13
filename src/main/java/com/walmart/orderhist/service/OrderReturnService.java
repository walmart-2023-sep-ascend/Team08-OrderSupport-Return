package com.walmart.orderhist.service;

import com.walmart.orderhist.dto.OrderReturnResponse;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;
import org.springframework.http.ResponseEntity;

public interface OrderReturnService {

	public ResponseEntity<OrderReturnResponse> orderReturn(String orderId, String reason) throws ExternalReturnNotRunningException;
	
}
