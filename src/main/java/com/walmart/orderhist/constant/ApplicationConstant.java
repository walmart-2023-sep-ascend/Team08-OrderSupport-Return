package com.walmart.orderhist.constant;

public class ApplicationConstant {
	
	
	private ApplicationConstant() {
		 throw new IllegalStateException("Utility class");
	}
	
	public static final String ASCEND_DATABASE = "Ascend";
    public static final String USER_COLLECTION = "Users";
    public static final String ORDER_COLLECTION = "Order";
    public static final String ORDER_ID = "orderId";
    public static final String ORDER_STATUS = "orderStatus";  
    
    public static final String DATE_OF_ORDER =  "dateOfOrder";
    public static final String ORDER_ITEMS =  "orderItems.items";
    
    public static final String ID = "id";
    
    public static final String USER_ID = "userId";
}
