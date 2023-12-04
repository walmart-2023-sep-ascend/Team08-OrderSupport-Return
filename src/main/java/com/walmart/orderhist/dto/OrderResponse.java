
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
	public OrderResponse(int i, int j, int k, Date date, double d, String string, String string2, Date date2,
			String string3) {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public String getStatusOfOrder() {
		return statusOfOrder;
	}
	public void setStatusOfOrder(String statusOfOrder) {
		this.statusOfOrder = statusOfOrder;
	}
	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", cartId=" + cartId + ", userId=" + userId + ", dateOfOrder="
				+ dateOfOrder + ", amount=" + amount + ", modeOfPayment=" + modeOfPayment + ", paymentStatus="
				+ paymentStatus + ", dateOfDelivery=" + dateOfDelivery + ", statusOfOrder=" + statusOfOrder
				+ ", getOrderId()=" + getOrderId() + ", getCartId()=" + getCartId() + ", getUserId()=" + getUserId()
				+ ", getDateOfOrder()=" + getDateOfOrder() + ", getAmount()=" + getAmount() + ", getModeOfPayment()="
				+ getModeOfPayment() + ", getPaymentStatus()=" + getPaymentStatus() + ", getDateOfDelivery()="
				+ getDateOfDelivery() + ", getStatusOfOrder()=" + getStatusOfOrder() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
