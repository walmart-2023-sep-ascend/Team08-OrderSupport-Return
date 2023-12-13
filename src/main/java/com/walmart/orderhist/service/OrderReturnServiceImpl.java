package com.walmart.orderhist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.walmart.orderhist.dto.OrderReturnResponse;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;
import com.walmart.orderhist.rest.ReturnAPI;

@Service
@Slf4j
public class OrderReturnServiceImpl implements OrderReturnService {

	@Autowired
	ReturnAPI returnAPI;
	
	private static final Logger log = LoggerFactory.getLogger(OrderReturnServiceImpl.class);
	
    public ResponseEntity<OrderReturnResponse> orderReturn(String orderId, String reason) throws ExternalReturnNotRunningException {
	    try {
	    	OrderReturnResponse trackinfo=returnAPI.getReturnDetails(orderId, reason);
	    	if(trackinfo!=null) {
	    		return ResponseEntity.ok().body(trackinfo);
	    	}
	    	else {
	    		throw new ExternalReturnNotRunningException("User Not Found or External API Return Service down");
	    	}
	    }catch (Exception e) {
	    	log.info("External API Return Service down");
	    	throw new ExternalReturnNotRunningException("External API Return Service down");
		}
	        
    }
}
