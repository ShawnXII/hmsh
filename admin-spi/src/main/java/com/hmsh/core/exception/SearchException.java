package com.hmsh.core.exception;
/**
 * Controller 层错误处理
 * @author ShawnXII
 *
 */
public class SearchException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1738602486694025177L;
	
	public SearchException(String message) {
		super(message);
	}

	public SearchException(Throwable e) {
		super(e);
	}

	public SearchException(String message, Throwable e) {
		super(message, e);
	}

	public SearchException() {
		super();
	}

}
