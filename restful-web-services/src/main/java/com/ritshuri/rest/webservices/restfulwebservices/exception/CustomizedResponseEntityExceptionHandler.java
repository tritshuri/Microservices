package com.ritshuri.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ritshuri.rest.webservices.restfulwebservices.user.PostNotFoundException;
import com.ritshuri.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(exResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public final ResponseEntity<Object> handlePostNotFoundException(PostNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(exResponse, HttpStatus.NOT_FOUND);
	}
}
