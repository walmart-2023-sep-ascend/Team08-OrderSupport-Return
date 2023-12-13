package com.walmart.orderhist.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.orderhist.dto.OrderReturnResponse;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;

@Service
public class ReturnAPI {
	
	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(ReturnAPI.class);

	public OrderReturnResponse getReturnDetails(String orderId, String reason) throws ExternalReturnNotRunningException {

	    try {
    		String uri="https://orderreturn.free.beeceptor.com/track/"+orderId+"/"+reason;
    		String jsonResponse=restTemplate.getForObject(uri, String.class);
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	log.info(jsonResponse);
	    	if(jsonResponse!=null) {
	    		OrderReturnResponse returnObject = objectMapper.readValue(jsonResponse, OrderReturnResponse.class);
	    		return returnObject;
	    	}
	    	else {
	    		throw new ExternalReturnNotRunningException("Order not found");
	    	}
	    }catch (Exception e) {
	    	log.info("External API Return Service down");
	    	throw new ExternalReturnNotRunningException("External Return APIs not running");
		}
	}
}
