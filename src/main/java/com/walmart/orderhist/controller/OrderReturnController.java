package com.walmart.orderhist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.walmart.orderhist.dto.OrderReturnResponse;
import com.walmart.orderhist.dto.ReturnRequest;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;
import com.walmart.orderhist.service.OrderReturnService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderReturnController {
	@GetMapping("/welcomeToReturn")
	public String healthCheck() {
		return "service is up";
	}
	@Autowired
	OrderReturnService orderReturnService;
	
	@PostMapping("/returns")
	public ResponseEntity<OrderReturnResponse> orderReturn(@RequestBody ReturnRequest returnRequest) {
		ResponseEntity<OrderReturnResponse> orderReturnInfo = null;
		try {
			
			if(returnRequest.getOrderId()!=null || returnRequest.getReason() != null)
			{
				
				orderReturnInfo = orderReturnService.orderReturn(returnRequest.getOrderId(),returnRequest.getReason());
							
				OrderReturnResponse returnResponse = new OrderReturnResponse();
				
				returnResponse.setReturnID(orderReturnInfo.getBody().getReturnID());
				returnResponse.setRefundStatus(orderReturnInfo.getBody().getRefundStatus());
				returnResponse.setMessage(orderReturnInfo.getBody().getMessage());
				
				System.out.println(returnResponse);
			}
			else
			{
				System.out.println("OrderID or Reason is not Entered.");
			}
			return orderReturnInfo;
			
		} catch (ExternalReturnNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
}
