package com.example.demo.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.AppError;
import com.example.demo.exception.ValidationException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<AppError> validationExceptionHandler(ValidationException ex){
		
		LOGGER.info("Enter Into Validation Exception Handler..!");
		
		AppError error = new AppError();
		error.setErrocode(324);
		error.setDescription(ex.getMessage());
		error.setException(ex);
		
		LOGGER.error("Error::"+error);
		
		ResponseEntity<AppError> re = ResponseEntity.badRequest().body(error);
		
		LOGGER.info("Exit From Validation Exception Handel..!");
		return re;
	}
}
