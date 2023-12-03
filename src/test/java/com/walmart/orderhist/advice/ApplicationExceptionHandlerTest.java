package com.walmart.orderhist.advice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.walmart.orderhist.exception.CartNotFoundException;
import com.walmart.orderhist.exception.CartServiceException;
import com.walmart.orderhist.exception.InvalidCartException;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.OrderServiceException;

@SpringBootTest
public class ApplicationExceptionHandlerTest {

	@Autowired
	private ApplicationExceptionHandler exceptionHandler;

	@Mock
	private OrderNotFoundException orderNotFoundException;

	@Mock
	private CartNotFoundException cartNotFoundException;

	@Mock
	private OrderServiceException orderServiceException;

	@Mock
	private CartServiceException cartServiceException;

	@Mock
	private InvalidCartException invalidCartException;

	@Mock
	private Exception genericException;

	@Test
    public void testHandleOrderNotFoundException() {
        when(orderNotFoundException.getMessage()).thenReturn("Order not found");

        ResponseEntity<String> response = exceptionHandler.handleOrderNotFoundException(orderNotFoundException);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Order Exception Order not found", response.getBody());
    }

	@Test
    public void testHandleCartNotFoundException() {
        when(cartNotFoundException.getMessage()).thenReturn("Cart not found");

        ResponseEntity<String> response = exceptionHandler.handleCartNotFoundException(cartNotFoundException);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Cart Exception Cart not found", response.getBody());
    }

	@Test
    public void testHandleOrderServiceException() {
        when(orderServiceException.getMessage()).thenReturn("Order service exception");

        ResponseEntity<String> response = exceptionHandler.handleOrderServiceException(orderServiceException);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Order Exception Order service exception", response.getBody());
    }

	@Test
    public void testHandleCartServiceException() {
        when(cartServiceException.getMessage()).thenReturn("Cart service exception");

        ResponseEntity<String> response = exceptionHandler.handleCartServiceException(cartServiceException);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Cart Exception Cart service exception", response.getBody());
    }

	@Test
    public void testHandleInvalidCartException() {
        when(invalidCartException.getMessage()).thenReturn("Invalid cart exception");

        ResponseEntity<String> response = exceptionHandler.handleInvalidCartException(invalidCartException);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Cart Exception Invalid cart exception", response.getBody());
    }

	@Test
    public void testHandleRunTimeException() {
        when(genericException.getMessage()).thenReturn("Some internal error");

        ResponseEntity<String> response = exceptionHandler.handleRunTimeException(genericException);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal Server Error, Please refresh the page", response.getBody());
    }
}
