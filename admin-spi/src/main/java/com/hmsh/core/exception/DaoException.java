package com.hmsh.core.exception;

public class DaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8871941810495976506L;
	
	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable e) {
		super(e);
	}

	public DaoException(String message, Throwable e) {
		super(message, e);
	}

	public DaoException() {
		super();
	}

}
