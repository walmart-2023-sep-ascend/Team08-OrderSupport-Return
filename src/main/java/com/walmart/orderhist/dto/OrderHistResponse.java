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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public List<ProductResponse> getProducts() {
		return products;
	}
	public void setProducts(List<ProductResponse> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "OrderHistResponse [orderId=" + orderId + ", dateOfOrder=" + dateOfOrder + ", amount=" + amount
				+ ", modeOfPayment=" + modeOfPayment + ", paymentStatus=" + paymentStatus + ", dateOfDelivery="
				+ dateOfDelivery + ", statusOfOrder=" + statusOfOrder + ", products=" + products + ", getOrderId()="
				+ getOrderId() + ", getDateOfOrder()=" + getDateOfOrder() + ", getAmount()=" + getAmount()
				+ ", getModeOfPayment()=" + getModeOfPayment() + ", getPaymentStatus()=" + getPaymentStatus()
				+ ", getDateOfDelivery()=" + getDateOfDelivery() + ", getStatusOfOrder()=" + getStatusOfOrder()
				+ ", getProducts()=" + getProducts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

    
}
