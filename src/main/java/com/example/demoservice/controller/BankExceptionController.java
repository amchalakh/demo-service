package com.example.demoservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demoservice.exception.CustomerNotFoundException;

@ControllerAdvice
public class BankExceptionController {
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException customerNotFoundException){
		return new ResponseEntity<Object>("Customer Not Found", HttpStatus.NOT_FOUND);
	}

}
