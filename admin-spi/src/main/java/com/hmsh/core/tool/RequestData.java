package com.hmsh.core.tool;

public class RequestData implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 101490598156232988L;

	//是否处理成功
	private Boolean flag=true;
	
	//成功信息
	private String message;
	
	//错误信息
	private String errorMsg;
	
	private Object data;
	
	//操作类型 默认添加
	private String type="add";
	
	public RequestData(){
		super();
	}
	
	public RequestData(Boolean flag, String message) {
		this();
		this.flag = flag;
		if(this.flag){
			this.message = message;
		}else{
			this.errorMsg=message;
		}		
	}
	public RequestData(Boolean flag, String message,Object data) {
		this(flag,message);
		this.data=data;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
