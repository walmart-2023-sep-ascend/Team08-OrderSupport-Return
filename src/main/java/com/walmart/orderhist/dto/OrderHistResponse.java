package com.walmart.orderhist.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistResponse {
	
	private int orderId;
    private Date dateOfOrder;
    private double amount;
    private String modeOfPayment;
    private String paymentStatus;
    private Date dateOfDelivery;
    private String statusOfOrder;
    private List<ProductResponse> products;

}
