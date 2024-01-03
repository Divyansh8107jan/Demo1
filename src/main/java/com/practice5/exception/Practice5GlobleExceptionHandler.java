package com.practice5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Practice5GlobleExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Practice5ResourseNotFoudException.class)
	public ResponseEntity<?> practice5ResourseNotFoudException(
			
			Practice5ResourseNotFoudException e,
			WebRequest webRequest
			
			){
		return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHander(
			
			Exception e,
			WebRequest webRequest
			
			){
		return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
