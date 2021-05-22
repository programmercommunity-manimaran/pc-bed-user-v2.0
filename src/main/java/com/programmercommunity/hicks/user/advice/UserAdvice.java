package com.programmercommunity.hicks.user.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.programmercommunity.hicks.user.exception.UserNotFound;
import com.programmercommunity.hicks.user.model.Response;

@ControllerAdvice
public class UserAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<Response> handleUserNotFoundException(UserNotFound ex, WebRequest request) {
		return new ResponseEntity<Response>(new Response(404, "Not found"), HttpStatus.NOT_FOUND);
	}

}