package com.hmsh.app.vo.goods;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:ShopGoodsSku <br>
 * Description:(商户商品关联表VO实体类) <br>
 * Copyright: Copyright © 2017 <br>
 * Company: 深圳市阿凡达互联网技术开发有限公司
 * 
 * @author Tom Tang
 * @version v1.0 2017-01-17
 */
public class ShopGoodsSku extends BaseEntity<Long> {

	/** (序列化UID) */
	private static final long serialVersionUID = 1552452643466397229L;

	//
	private Long dmId;
	// 商家ID
	private Long userShopId;
	// 商品skuId
	private Long goodsSkuId;
	// 折扣
	private Double discount;
	// 销售数量
	private Integer salesNum;
	// 库存
	private Integer stockNum;
	//
	private String remarks;
	// 创建人
	private String createBy;
	// 创建时间
	private Long createTime;
	// 最后一次更新人
	private String updateBy;
	// 更新时间
	private Long updateTime;

	public ShopGoodsSku() {
		super();
	}

	public Long getDmId() {
		return this.dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public Long getUserShopId() {
		return this.userShopId;
	}

	public void setUserShopId(Long userShopId) {
		this.userShopId = userShopId;
	}

	public Long getGoodsSkuId() {
		return this.goodsSkuId;
	}

	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getSalesNum() {
		return this.salesNum;
	}

	public void setSalesNum(Integer salesNum) {
		this.salesNum = salesNum;
	}

	public Integer getStockNum() {
		return this.stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Long getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public Long getId() {
		return this.dmId;
	}

	@Override
	public void setId(Long id) {
		this.dmId = id;
	}

	@Override
	public String toString() {
		return "ShopGoodsSku[" + "dmId=" + dmId + ",userShopId=" + userShopId + ",goodsSkuId=" + goodsSkuId
				+ ",discount=" + discount + ",salesNum=" + salesNum + ",stockNum=" + stockNum + ",remarks=" + remarks
				+ ",createBy=" + createBy + ",createTime=" + createTime + ",updateBy=" + updateBy + ",updateTime="
				+ updateTime + ']';
	}

}
