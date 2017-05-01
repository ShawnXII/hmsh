package com.hmsh.admin.request;
/**
 * 返回编号
 * @author ShawnXII
 *
 */
public enum ReturnCode {
	
	SUCCESS(200,"操作成功",true);
	
	private Integer code;
	
	private String message;
	
	private boolean flag;
	
	private ReturnCode(Integer code,String message,boolean flag){
		this.setCode(code);
		this.setMessage(message);
		this.setFlag(flag);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
