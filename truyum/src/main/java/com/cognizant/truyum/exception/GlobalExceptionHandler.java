package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Menu Item Not Found")
public class GlobalExceptionHandler extends Exception{

	private static final long serialVersionUID = 1L;
	
	public GlobalExceptionHandler(String arg0) {
		super(arg0);
	}

}
