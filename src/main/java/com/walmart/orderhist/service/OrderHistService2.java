package com.walmart.orderhist.service;

import org.springframework.http.ResponseEntity;

import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.UserNotFoundException;

public interface OrderHistService2 {
	
	public boolean userCheck(Integer userId);
	public ResponseEntity<String> orderHist(Integer userId)  throws UserNotFoundException,OrderNotFoundException;

}
