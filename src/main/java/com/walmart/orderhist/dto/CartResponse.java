package com.walmart.orderhist.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

	private Integer cartId;
	private Integer userId;
	private Double amount;
	private List<ProductResponse> products;
	public CartResponse(int i, int j, double d, List<ProductResponse> dummyProducts) {
		// TODO Auto-generated constructor stub
	}
	public CartResponse() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public List<ProductResponse> getProducts() {
		return products;
	}
	public void setProducts(List<ProductResponse> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "CartResponse [cartId=" + cartId + ", userId=" + userId + ", amount=" + amount + ", products=" + products
				+ ", getCartId()=" + getCartId() + ", getUserId()=" + getUserId() + ", getAmount()=" + getAmount()
				+ ", getProducts()=" + getProducts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	

}
