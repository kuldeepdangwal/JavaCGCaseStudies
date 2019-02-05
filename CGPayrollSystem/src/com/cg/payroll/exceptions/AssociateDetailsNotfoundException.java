package com.cg.payroll.exceptions;

public class AssociateDetailsNotfoundException extends RuntimeException {

	public AssociateDetailsNotfoundException() {
		super();
	}

	public AssociateDetailsNotfoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssociateDetailsNotfoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssociateDetailsNotfoundException(String message) {
		super(message);
	}

	public AssociateDetailsNotfoundException(Throwable cause) {
		super(cause);
	}
	
}
