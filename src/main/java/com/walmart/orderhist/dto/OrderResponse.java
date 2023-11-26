
package com.walmart.orderhist.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

	private int orderId;
	private int cartId;
	private int userId;
	private Date dateOfOrder;
	private double amount;
	private String modeOfPayment;
	private String paymentStatus;
	private Date dateOfDelivery;
	private String statusOfOrder;
	

}
