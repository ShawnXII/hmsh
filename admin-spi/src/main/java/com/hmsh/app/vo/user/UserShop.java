package com.hmsh.app.vo.user;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 商家用户
 * @author ShawnXII
 *
 */
@Document(collection = "usershop")
public class UserShop extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7230956887671527680L;
	
	private Integer isDirectCamp;		//是否直营店 0：否  1：是
	
	private Integer isIntegral;	    	//是否支持积分 0：否  1：是
	
	private String sysHeadImg;	   		//运营图片
	
	private Integer isSysImg; 	    //是否使用运营图片 0：不使用  1：使用
	
	private Integer isQuality;		//是否精选 商家 0：否    1：是
	
	/* 营业执照状态 0：未认证，1：已认证.3.营业执照初步通过,待审核 */
	private Integer firmAuthen;
	
	/* 商家扣点比例*/
	private Double scale;// 1
	
	private Integer isTemplate; // 是否使用模板1：是 其他代表否走默认
	

	
	public Integer getIsDirectCamp() {
		return isDirectCamp;
	}

	public void setIsDirectCamp(Integer isDirectCamp) {
		this.isDirectCamp = isDirectCamp;
	}

	public Integer getIsIntegral() {
		return isIntegral;
	}

	public void setIsIntegral(Integer isIntegral) {
		this.isIntegral = isIntegral;
	}

	public String getSysHeadImg() {
		return sysHeadImg;
	}

	public void setSysHeadImg(String sysHeadImg) {
		this.sysHeadImg = sysHeadImg;
	}

	public Integer getIsSysImg() {
		return isSysImg;
	}

	public void setIsSysImg(Integer isSysImg) {
		this.isSysImg = isSysImg;
	}

	public Integer getIsQuality() {
		return isQuality;
	}

	public void setIsQuality(Integer isQuality) {
		this.isQuality = isQuality;
	}

	public Integer getFirmAuthen() {
		return firmAuthen;
	}

	public void setFirmAuthen(Integer firmAuthen) {
		this.firmAuthen = firmAuthen;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public Integer getIsTemplate() {
		return isTemplate;
	}

	public void setIsTemplate(Integer isTemplate) {
		this.isTemplate = isTemplate;
	}

	
	
	

}
