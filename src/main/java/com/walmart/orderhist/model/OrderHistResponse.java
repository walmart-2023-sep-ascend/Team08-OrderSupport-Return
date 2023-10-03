package com.walmart.orderhist.model;

import java.util.List;

public class OrderHistResponse {	

	
	    private String orderNumber;
	    private String orderDate;
	    private String status;
	    private List<Item> items;
	    private double totalAmount;
	    private String paymentStatus;
	    private Address deliveryAddress;
		public String getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public List<Item> getItems() {
			return items;
		}
		public void setItems(List<Item> items) {
			this.items = items;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public Address getDeliveryAddress() {
			return deliveryAddress;
		}
		public void setDeliveryAddress(Address deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
		}
		@Override
		public String toString() {
			return "OrderHistResponse [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", status=" + status
					+ ", items=" + items + ", totalAmount=" + totalAmount + ", paymentStatus=" + paymentStatus
					+ ", deliveryAddress=" + deliveryAddress + "]";
		}

	    // getters and setters
	}

