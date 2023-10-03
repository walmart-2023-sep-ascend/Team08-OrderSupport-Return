package com.walmart.orderhist.service;

import org.springframework.http.ResponseEntity;

public interface OrderHistService {
	
	public boolean validUserCheck(Integer userId);
	public ResponseEntity<String> orderHist(Integer userId);

}
