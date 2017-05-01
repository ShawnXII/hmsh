package com.hmsh.app.vo.goods;

import java.util.InputMismatchException;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;



@Document(collection = "goods_class_shop")
public class GoodsClassShop extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6397216483934956940L;
	
	private Long dmId;
	
	
	private Long firstClassId;
	
	private Long secondClassId;
	
	private Long userShopId;
	
	

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public Long getFirstClassId() {
		return firstClassId;
	}

	public void setFirstClassId(Long firstClassId) {
		this.firstClassId = firstClassId;
	}

	public Long getSecondClassId() {
		return secondClassId;
	}

	public void setSecondClassId(Long secondClassId) {
		this.secondClassId = secondClassId;
	}

	public Long getUserShopId() {
		return userShopId;
	}

	public void setUserShopId(Long userShopId) {
		this.userShopId = userShopId;
	}

	@Override
	public void setId(Long id) throws InputMismatchException {
		this.dmId=id;
	}

	@Override
	public Long getId() {
		return this.dmId;
	}
	
}
