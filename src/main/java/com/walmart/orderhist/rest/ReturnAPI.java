package com.walmart.orderhist.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.orderhist.dto.OrderReturnResponse;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;

public class ReturnAPI {
	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(ReturnAPI.class);

	public OrderReturnResponse getReturnDetails(String orderNum, String reason) throws ExternalReturnNotRunningException {

	    try {
    		String uri="https://ascend-team08.free.beeceptor.com/track/"+orderNum+"/"+reason;
	    	String jsonResponse=restTemplate.getForObject(uri, String.class);
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	OrderReturnResponse returnObject = objectMapper.readValue(jsonResponse, OrderReturnResponse.class);
	    	log.info(jsonResponse);
	    	if(jsonResponse!=null) {
	    		return returnObject;
	    	}
	    	else {
	    		throw new ExternalReturnNotRunningException("External Tracker API not running");
	    	}
	    }catch (Exception e) {
	    	log.info("External API Tracker Service down");
	    	throw new ExternalReturnNotRunningException("External Tracker API not running");
//	    	return null;
		}
	}
}
