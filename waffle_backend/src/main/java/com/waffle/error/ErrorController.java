package com.waffle.error;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
	public String handleException(Exception e){
		return e.getMessage();
	}
}
