package com.devon.problem.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/******************************************************************************
 * Created: 09/18/2021
 * Description: Controller Advice class to handle exceptions across all REST
 * controllers
 * @version 1.0
 * @author Soumya Ranjan Parida
 * 
 *****************************************************************************/
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * This handler method handles all spring validation for model classes
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> validationErrorHandler(MethodArgumentNotValidException exception){
		List<String> errors = new ArrayList<>(exception.getFieldErrorCount());
		exception.getFieldErrors().forEach(fieldError -> {			
			errors.add(fieldError.getField() + " " +  fieldError.getDefaultMessage());
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This handler method handles all exceptions of type AnagramImpossibleException
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(AnagramImpossibleException.class)
	public ResponseEntity<String> validationErrorHandler(AnagramImpossibleException exception){
		String errMsg = exception.getMessage();
		
		return new ResponseEntity<>(errMsg, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
