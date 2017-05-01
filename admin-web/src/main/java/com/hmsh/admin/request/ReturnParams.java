package com.hmsh.admin.request;
/**
 * 返回参数封装
 * @author ShawnXII
 */
public class ReturnParams implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1320863283033358354L;
	//是否成功 (默认成功)
	private boolean flag=true;
	//返回信息
	private String message="";	
	//返回编号 200 正确
	private Integer code;
	
	
}
