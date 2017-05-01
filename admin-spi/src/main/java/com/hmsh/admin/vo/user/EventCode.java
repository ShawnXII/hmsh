package com.hmsh.admin.vo.user;

public enum EventCode {

	LOGIN_IN("用户登录"), LOGIN_OUT("退出登录"), REGISTER("用户注册"), UPDATE_ROLE("更改权限"), UPDATE_STATE("更改状态");
	
	private String describe;

	private EventCode(String describe) {
		this.describe = describe;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
