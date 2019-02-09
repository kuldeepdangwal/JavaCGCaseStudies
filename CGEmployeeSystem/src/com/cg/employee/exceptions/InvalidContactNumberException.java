package com.cg.employee.exceptions;

public class InvalidContactNumberException extends RuntimeException{

	public InvalidContactNumberException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidContactNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidContactNumberException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidContactNumberException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidContactNumberException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
