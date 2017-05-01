package com.hmsh.core.base.vo;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ValidationResult {

	// 校验结果是否有错
	private boolean hasErrors=false;

	// 校验错误信息
	private Map<String, String> errorMsg;

	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		if(this.hasErrors&&this.errorMsg!=null){
			Iterator<Entry<String, String>> ite=this.errorMsg.entrySet().iterator();
			while(ite.hasNext()){
				Entry<String, String> entry=ite.next();				
				sb.append("字段:").append(entry.getKey()).append("错误:").append(entry.getValue());
			}
		}
		return sb.toString();
	}
	
	
}
