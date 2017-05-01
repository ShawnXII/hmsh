package com.hmsh.app.vo.shop;

import com.hmsh.app.vo.user.UserShop;
import com.hmsh.core.base.vo.BaseEntity;

public class SellerStore extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7432603994280314683L;
    
	//
	private Long dmId;
	//
	private Long userId;
	//二级
	private Long twoCategoryId;
	//商户类型
	private Long storeType;
	//是否派送
	private Integer isSend;
	//派送范围
	private Integer deliveryRange;
	//派送费用
	private Double sendFee;
	//起送费用
	private Double sendOutUpFee;
	//有效时间
	private String validityTime;
	//店铺状态 0 正常  1关闭
	private Integer status;
	//开始时间
	private Long startTime;
	//结束时间
	private Long endTime;
	//餐盒费
	private Double mealFee;
	//是否支持到店 0支持 1不支持
	private Integer isStop;
	//免派送费
	private Double freeSendFee;
	//免包装费
	private Double freeMealFee;
	//折扣
	private Double scale;
	//返现
	private Double back;
	//金币赠送
	private Double goldGift;
	//最高赠送
	private Double highestGift;
	//最高返现
	private Double highestBack;
	//省ID
	private Long provinceId;
	//市ID
	private Long cityId;
	//县
	private Long countyId;
	//行政区名称
	private String district;
	//是否直营店 0 否 1 是
	private Integer isDirectCamp;
	//店铺禁用原因
	private String msgInfo;
	//0-正常 1-屏蔽
	private Integer isHide;
	//星级
	private Double rating;
	//关键字
	private String keyword;
	//状态
	private String showStatus;
	//行业显示值 
	private String cateValue;
	//店铺名称
	private String nickname;
	//手机号码
	private String mphonenum;
	//地址
	private String address;
	
	/*非数据库字段*/
	
	//商家用户信息
	private UserShop user;
	
	//IDs
	private String dmIds;

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTwoCategoryId() {
		return twoCategoryId;
	}

	public void setTwoCategoryId(Long twoCategoryId) {
		this.twoCategoryId = twoCategoryId;
	}

	public Long getStoreType() {
		return storeType;
	}

	public void setStoreType(Long storeType) {
		this.storeType = storeType;
	}

	public Integer getIsSend() {
		return isSend;
	}

	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}

	public Integer getDeliveryRange() {
		return deliveryRange;
	}

	public void setDeliveryRange(Integer deliveryRange) {
		this.deliveryRange = deliveryRange;
	}

	public Double getSendFee() {
		return sendFee;
	}

	public void setSendFee(Double sendFee) {
		this.sendFee = sendFee;
	}

	public Double getSendOutUpFee() {
		return sendOutUpFee;
	}

	public void setSendOutUpFee(Double sendOutUpFee) {
		this.sendOutUpFee = sendOutUpFee;
	}

	public String getValidityTime() {
		return validityTime;
	}

	public void setValidityTime(String validityTime) {
		this.validityTime = validityTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Double getMealFee() {
		return mealFee;
	}

	public void setMealFee(Double mealFee) {
		this.mealFee = mealFee;
	}

	public Integer getIsStop() {
		return isStop;
	}

	public void setIsStop(Integer isStop) {
		this.isStop = isStop;
	}

	public Double getFreeSendFee() {
		return freeSendFee;
	}

	public void setFreeSendFee(Double freeSendFee) {
		this.freeSendFee = freeSendFee;
	}

	public Double getFreeMealFee() {
		return freeMealFee;
	}

	public void setFreeMealFee(Double freeMealFee) {
		this.freeMealFee = freeMealFee;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public Double getBack() {
		return back;
	}

	public void setBack(Double back) {
		this.back = back;
	}

	public Double getGoldGift() {
		return goldGift;
	}

	public void setGoldGift(Double goldGift) {
		this.goldGift = goldGift;
	}

	public Double getHighestGift() {
		return highestGift;
	}

	public void setHighestGift(Double highestGift) {
		this.highestGift = highestGift;
	}

	public Double getHighestBack() {
		return highestBack;
	}

	public void setHighestBack(Double highestBack) {
		this.highestBack = highestBack;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getIsDirectCamp() {
		return isDirectCamp;
	}

	public void setIsDirectCamp(Integer isDirectCamp) {
		this.isDirectCamp = isDirectCamp;
	}

	public String getMsgInfo() {
		return msgInfo;
	}

	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}

	public Integer getIsHide() {
		return isHide;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

	public String getCateValue() {
		return cateValue;
	}

	public void setCateValue(String cateValue) {
		this.cateValue = cateValue;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMphonenum() {
		return mphonenum;
	}

	public void setMphonenum(String mphonenum) {
		this.mphonenum = mphonenum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserShop getUser() {
		return user;
	}

	public void setUser(UserShop user) {
		this.user = user;
	}

	public String getDmIds() {
		return dmIds;
	}

	public void setDmIds(String dmIds) {
		this.dmIds = dmIds;
	}

	@Override
	public Long getId() {
		return this.dmId;
	}

	@Override
	public void setId(Long id) {
		this.dmId=id;
	}
	
	

}
