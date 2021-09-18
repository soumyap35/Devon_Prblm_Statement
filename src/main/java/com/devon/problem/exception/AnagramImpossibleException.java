package com.devon.problem.exception;

/******************************************************************************
 * Created: 09/18/2021
 * Description: Exception class
 * @version 1.0
 * @author Soumya Ranjan Parida
 * 
 *****************************************************************************/
public class AnagramImpossibleException extends Exception {
	private static final long serialVersionUID = -4950525971084554645L;

	public AnagramImpossibleException() {
		super();
	}

	public AnagramImpossibleException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnagramImpossibleException(String message) {
		super(message);
	}

	public AnagramImpossibleException(Throwable cause) {
		super(cause);
	}
	
	
	
}
