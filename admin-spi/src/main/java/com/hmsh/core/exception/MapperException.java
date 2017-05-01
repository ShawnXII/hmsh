package com.hmsh.core.exception;

/**
 * @author wangxiang
 */
public class MapperException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 715906529912116867L;

	public MapperException() {
        super();
    }

    public MapperException(String message) {
        super(message);
    }

    public MapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public MapperException(Throwable cause) {
        super(cause);
    }

}
