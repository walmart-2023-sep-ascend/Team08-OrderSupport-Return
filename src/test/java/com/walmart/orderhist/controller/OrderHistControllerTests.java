package com.walmart.orderhist.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;

import com.walmart.orderhist.dto.OrderHistResponse;
import com.walmart.orderhist.exception.CartNotFoundException;
import com.walmart.orderhist.exception.CartServiceException;
import com.walmart.orderhist.exception.InvalidCartException;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.service.OrderHistServiceImpl;

@AutoConfigureMockMvc
@WebMvcTest(OrderHistController.class)
public class OrderHistControllerTests {

	private OrderHistServiceImpl orderHistServiceImpl;
	private OrderHistController orderHistController;

	@BeforeEach
	void setUp() {
		orderHistServiceImpl = mock(OrderHistServiceImpl.class);
		orderHistController = new OrderHistController(orderHistServiceImpl);
	}

	@Test
	void getOrderHist_SuccessfulCase_ShouldReturnOkResponse() throws Exception {
		// Arrange
		String userId = "testUserId";
		OrderHistResponse mockOrderHistResponse = new OrderHistResponse(/* provide necessary details */);

		when(orderHistServiceImpl.getOrderHistory(userId)).thenReturn(mockOrderHistResponse);

		// Act
		ResponseEntity<OrderHistResponse> response = orderHistController.getOrderHist(userId);

		// Assert
		assertNotNull(response);
		assertEquals(200, response.getStatusCode());
		assertEquals(mockOrderHistResponse, response.getBody());
	}

	@Test
	void getOrderHist_CartServiceException_ShouldReturnInternalServerError() throws Exception {
		// Arrange
		String userId = "testUserId";

		when(orderHistServiceImpl.getOrderHistory(userId))
				.thenThrow(new CartServiceException("Cart service exception"));

		// Act
		ResponseEntity<OrderHistResponse> response = orderHistController.getOrderHist(userId);

		// Assert
		assertNotNull(response);
		assertEquals(500, response.getStatusCode());
		assertNull(response.getBody());
	}

	@Test
	void getOrderHist_OrderNotFoundException_ShouldReturnNotFoundResponse() throws Exception {
		// Arrange
		String userId = "testUserId";

		when(orderHistServiceImpl.getOrderHistory(userId)).thenThrow(new OrderNotFoundException("Order not found"));

		// Act
		ResponseEntity<OrderHistResponse> response = orderHistController.getOrderHist(userId);

		// Assert
		assertNotNull(response);
		assertEquals(404, response.getStatusCode());
		assertNull(response.getBody());
	}

	@Test
	void getOrderHist_CartNotFoundException_ShouldReturnNotFoundResponse() throws Exception {
		// Arrange
		String userId = "testUserId";

		when(orderHistServiceImpl.getOrderHistory(userId)).thenThrow(new CartNotFoundException("Cart not found"));

		// Act
		ResponseEntity<OrderHistResponse> response = orderHistController.getOrderHist(userId);

		// Assert
		assertNotNull(response);
		assertEquals(404, response.getStatusCode());
		assertNull(response.getBody());
	}

	@Test
	void getOrderHist_InvalidCartException_ShouldReturnBadRequestResponse() throws Exception {
		// Arrange
		String userId = "testUserId";

		when(orderHistServiceImpl.getOrderHistory(userId)).thenThrow(new InvalidCartException("Invalid cart"));

		// Act
		ResponseEntity<OrderHistResponse> response = orderHistController.getOrderHist(userId);

		// Assert
		assertNotNull(response);
		assertEquals(400, response.getStatusCode());
		assertNull(response.getBody());
	}
}
