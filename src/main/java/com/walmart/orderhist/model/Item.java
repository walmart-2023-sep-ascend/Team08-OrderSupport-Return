package com.walmart.orderhist.model;

public class Item {
	
	private String itemName;
    private int quantity;
    private double unitPrice;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

}
