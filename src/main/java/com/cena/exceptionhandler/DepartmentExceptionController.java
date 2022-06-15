package com.cena.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionController  {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> departmentNotFoundException(DepartmentNotFoundException exception){
		return new ResponseEntity<>("Department Not Found",HttpStatus.NOT_FOUND);
	}
}
