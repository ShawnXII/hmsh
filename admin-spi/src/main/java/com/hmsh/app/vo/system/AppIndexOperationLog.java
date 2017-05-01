package com.hmsh.app.vo.system;

import java.util.InputMismatchException;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:AppIndexOperationLog
 * <br>Description:(首页设置操作日志VO实体类)
 * <br>Copyright: Copyright © 2017
 * <br>Company: 深圳市阿凡达互联网技术开发有限公司
 * @author Tom Tang
 * @version v1.0 2017-01-05
 */
public class AppIndexOperationLog extends BaseEntity<java.lang.Long> {

    /**(序列化UID)*/
    private static final long serialVersionUID = 7705747734045347614L;
    
	//
	private Long dmId;
	//操作人ID
	private Long operUserId;
	//操作人名称
	private String operUserName;
	//操作内容
	private String operContent;
	//操作时间
	private String operResult;
	//备注
	private String remarks;
	//操作对象dmId
	private Long targetDmId;
	//创建时间
	private Long crtime;
	
	public AppIndexOperationLog(){
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
    public Long getOperUserId(){
        return this.operUserId;
    }
    public void setOperUserId(Long operUserId){
        this.operUserId = operUserId;
    }
    public String getOperUserName(){
        return this.operUserName;
    }
    public void setOperUserName(String operUserName){
        this.operUserName = operUserName;
    }
    public String getOperContent(){
        return this.operContent;
    }
    public void setOperContent(String operContent){
        this.operContent = operContent;
    }
    public String getOperResult(){
        return this.operResult;
    }
    public void setOperResult(String operResult){
        this.operResult = operResult;
    }
    public String getRemarks(){
        return this.remarks;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    public Long getTargetDmId(){
        return this.targetDmId;
    }
    public void setTargetDmId(Long targetDmId){
        this.targetDmId = targetDmId;
    }
    public Long getCrtime(){
        return this.crtime;
    }
    public void setCrtime(Long crtime){
        this.crtime = crtime;
    }
}
