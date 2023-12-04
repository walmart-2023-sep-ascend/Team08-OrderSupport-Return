package com.walmart.orderhist.dto;

//import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class OrderReturnResponse {
	@JsonProperty("returnID")
	private String returnID;
	@JsonProperty("refundStatus")
	private String refundStatus;
	@JsonProperty("message")
	private String message;
	public String getReturnID() {
		return returnID;
	}
	public void setReturnID(String returnID) {
		this.returnID = returnID;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OrderReturnResponse [returnID=" + returnID + ", refundStatus=" + refundStatus + ", message=" + message
				+ ", getReturnID()=" + getReturnID() + ", getRefundStatus()=" + getRefundStatus() + ", getMessage()="
				+ getMessage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
