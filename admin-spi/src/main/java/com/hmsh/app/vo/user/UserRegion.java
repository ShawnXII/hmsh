package com.hmsh.app.vo.user;

import java.util.InputMismatchException;

import com.hmsh.core.base.vo.BaseEntity;

public class UserRegion  extends BaseEntity<Long>{

	/**()*/
	private static final long serialVersionUID = 1L;
	/**
	 * 输入地址
	 */
	private String address;
	/** 所在省ID */
	private java.lang.Long provinceId;
	/** 所在市ID */
	private java.lang.Long cityId;
	/** 所在县ID */
	private java.lang.Long countyId;
	/**
	 *	选择地区
	 */
	private String region;
	
	
	private Long dmId;
	
	@Override
	public void setId(Long id) throws InputMismatchException {
		this.dmId = id;
	}

	@Override
	public Long getId() {
		return this.dmId;
	}

	
	/** 行政区 */
	private String district;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.lang.Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(java.lang.Long provinceId) {
		this.provinceId = provinceId;
	}

	public java.lang.Long getCityId() {
		return cityId;
	}

	public void setCityId(java.lang.Long cityId) {
		this.cityId = cityId;
	}

	public java.lang.Long getCountyId() {
		return countyId;
	}

	public void setCountyId(java.lang.Long countyId) {
		this.countyId = countyId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}	
}
