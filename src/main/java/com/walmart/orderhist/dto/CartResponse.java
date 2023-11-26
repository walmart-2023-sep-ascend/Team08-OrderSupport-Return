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

	

}
