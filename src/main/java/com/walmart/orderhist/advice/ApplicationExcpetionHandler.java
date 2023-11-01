package com.walmart.orderhist.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.UserNotFoundException;

@ControllerAdvice
public class ApplicationExcpetionHandler {

	
	  @ExceptionHandler(OrderNotFoundException.class)
	    public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException e) {
	        return new ResponseEntity<>("Order Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	  
	  @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
	        return new ResponseEntity<>("User Exception: " + e.getMessage(), HttpStatus.FORBIDDEN);
	    }
	  
	  @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleRunTimeException(Exception e) {
	        return new ResponseEntity<>("Internal Server Error ,Please refresh the page " , HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
