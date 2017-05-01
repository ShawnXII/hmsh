package com.hmsh.app.vo.system;

import java.util.InputMismatchException;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:CustomMsg
 * <br>Description:(消息设置VO实体类)
 * <br>Copyright: Copyright © 2017
 * <br>Company: 深圳市阿凡达互联网技术开发有限公司
 * @author Tom Tang
 * @version v1.0 2017-01-04
 */
public class CustomMsg extends BaseEntity<java.lang.Long> {

    /**(序列化UID)*/
    private static final long serialVersionUID = 3932106795866997052L;
    
	//主键
	private Long dmId;
	//消息内容
	private String message;
	//消息类型
	private Integer msgType;
	//创建时间
	private Long crtime;
	//类型CODE值
	private String typeCode;
	//类型说明
	private String typeMsg;
	//环境
	private Integer environment;
	
	public CustomMsg(){
		super();
	}
	
	@Override
	public void setId(Long id) throws InputMismatchException {
		this.dmId = id;
	}

	@Override
	public Long getId() {
		return this.dmId;
	}

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public Integer getMsgType(){
        return this.msgType;
    }
    public void setMsgType(Integer msgType){
        this.msgType = msgType;
    }
    public Long getCrtime(){
        return this.crtime;
    }
    public void setCrtime(Long crtime){
        this.crtime = crtime;
    }
    public String getTypeCode(){
        return this.typeCode;
    }
    public void setTypeCode(String typeCode){
        this.typeCode = typeCode;
    }
    public String getTypeMsg(){
        return this.typeMsg;
    }
    public void setTypeMsg(String typeMsg){
        this.typeMsg = typeMsg;
    }
    public Integer getEnvironment(){
        return this.environment;
    }
    public void setEnvironment(Integer environment){
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CustomMsg[" +
        "dmId=" + dmId +
        ",message=" + message +
        ",msgType=" + msgType +
        ",crtime=" + crtime +
        ",typeCode=" + typeCode +
        ",typeMsg=" + typeMsg +
        ",environment=" + environment +
        ']';
    }

}
