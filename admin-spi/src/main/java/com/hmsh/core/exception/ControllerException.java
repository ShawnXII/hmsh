package com.hmsh.core.exception;
/**
 * Controller 层错误处理
 * @author ShawnXII
 *
 */
public class ControllerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1738602486694025177L;
	
	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(Throwable e) {
		super(e);
	}

	public ControllerException(String message, Throwable e) {
		super(message, e);
	}

	public ControllerException() {
		super();
	}

}
