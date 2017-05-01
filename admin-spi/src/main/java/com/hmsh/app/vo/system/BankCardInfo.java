package com.hmsh.app.vo.system;

import java.util.InputMismatchException;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:BankCardInfo
 * <br>Description:(银行卡管理VO实体类)
 * <br>Copyright: Copyright © 2017
 * <br>Company: 深圳市阿凡达互联网技术开发有限公司
 * @author Tom Tang
 * @version v1.0 2017-01-06
 */
public class BankCardInfo extends BaseEntity<java.lang.Long> {

    /**(序列化UID)*/
    private static final long serialVersionUID = 8249724648278476919L;
    
	//
	private Long dmID;
	//
	private Long userId;
	//卡号
	private String cardNum;
	//银行名称
	private String bankName;
	//添加时间
	private Long crtime;
	//卡类型
	private String bankType;
	//
	private String cardholderName;
	//
	private String bankArea;
	//
	private String strCardName;
	//
	private String strValid;
	//
	private Integer accountType;
	
	public BankCardInfo(){
		super();
	}
	
	@Override
	public void setId(Long id) throws InputMismatchException {
		this.dmID = id;
	}

	@Override
	public Long getId() {
		return this.dmID;
	}

	public Long getDmID() {
		return dmID;
	}

	public void setDmID(Long dmID) {
		this.dmID = dmID;
	}
    public Long getUserId(){
        return this.userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public String getCardNum(){
        return this.cardNum;
    }
    public void setCardNum(String cardNum){
        this.cardNum = cardNum;
    }
    public String getBankName(){
        return this.bankName;
    }
    public void setBankName(String bankName){
        this.bankName = bankName;
    }
    public Long getCrtime(){
        return this.crtime;
    }
    public void setCrtime(Long crtime){
        this.crtime = crtime;
    }
    public String getBankType(){
        return this.bankType;
    }
    public void setBankType(String bankType){
        this.bankType = bankType;
    }
    public String getCardholderName(){
        return this.cardholderName;
    }
    public void setCardholderName(String cardholderName){
        this.cardholderName = cardholderName;
    }
    public String getBankArea(){
        return this.bankArea;
    }
    public void setBankArea(String bankArea){
        this.bankArea = bankArea;
    }
    public String getStrCardName(){
        return this.strCardName;
    }
    public void setStrCardName(String strCardName){
        this.strCardName = strCardName;
    }
    public String getStrValid(){
        return this.strValid;
    }
    public void setStrValid(String strValid){
        this.strValid = strValid;
    }
    public Integer getAccountType(){
        return this.accountType;
    }
    public void setAccountType(Integer accountType){
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "BankCardInfo[" +
        "dmID=" + dmID +
        ",userId=" + userId +
        ",cardNum=" + cardNum +
        ",bankName=" + bankName +
        ",crtime=" + crtime +
        ",bankType=" + bankType +
        ",cardholderName=" + cardholderName +
        ",bankArea=" + bankArea +
        ",strCardName=" + strCardName +
        ",strValid=" + strValid +
        ",accountType=" + accountType +
        ']';
    }

}
