package com.walmart.orderhist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.walmart.orderhist.dto.CartResponse;
import com.walmart.orderhist.dto.OrderHistResponse;
import com.walmart.orderhist.dto.OrderResponse;
import com.walmart.orderhist.dto.ProductResponse;
import com.walmart.orderhist.exception.CartNotFoundException;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.rest.CartAPI;
import com.walmart.orderhist.rest.OrderAPI;
import com.walmart.orderhist.service.OrderHistServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class Team08OrderHistoryTrackerApplicationTests {

	@MockBean
	private CartAPI cartAPI;

	@MockBean
	private OrderAPI orderAPI;

	@Autowired
	private OrderHistServiceImpl orderService;

	@Test
	void getOrderHistory_WhenCartAndOrderMatch_ShouldReturnOrderHistResponse() throws Exception {
		// Arrange
		String userId = "testUserId";

		List<ProductResponse> dummyProducts = Arrays.asList(new ProductResponse(1, 10), new ProductResponse(2, 20)

		);
		CartResponse mockCartResponse = new CartResponse(123, 456, 789.0, dummyProducts);
		OrderResponse mockOrderResponse = new OrderResponse(789, 123, 456, new Date(), 1000.0, "Credit Card", "Paid",
				new Date(), "Delivered");

		when(cartAPI.getCartDetails(userId)).thenReturn(mockCartResponse);
		when(orderAPI.getOrderDetails(userId)).thenReturn(mockOrderResponse);

		// Act
		OrderHistResponse result = orderService.getOrderHistory(userId);

		// Assert
		assertNotNull(result);

	}

	@Test
	void getOrderHistory_WhenCartNotFound_ShouldThrowCartNotFoundException() throws Exception {
		// Arrange
		String userId = "testUserId";

		when(cartAPI.getCartDetails(userId)).thenReturn(null);

		// Act and Assert
		assertThrows(CartNotFoundException.class, () -> orderService.getOrderHistory(userId));
	}

	@Test
	void getOrderHistory_WhenOrderNotFound_ShouldThrowOrderNotFoundException() throws Exception {
		// Arrange
		String userId = "testUserId";
		CartResponse mockCartResponse = new CartResponse(/* provide necessary details */);

		when(cartAPI.getCartDetails(userId)).thenReturn(mockCartResponse);
		when(orderAPI.getOrderDetails(userId)).thenReturn(null);

		// Act and Assert
		assertThrows(OrderNotFoundException.class, () -> orderService.getOrderHistory(userId));
	}

}
