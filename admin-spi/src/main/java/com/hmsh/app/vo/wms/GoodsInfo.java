package com.hmsh.app.vo.wms;

import com.hmsh.core.base.vo.BaseEntity;
/**
 * 商品信息
 * @author leichao
 *
 */
public class GoodsInfo extends BaseEntity<Long>{
	
	private static final long serialVersionUID = -8049114437721559586L;
	
	private Long id;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品主图
	 */
	private String image;
	
	private Long goodsID;
	
	public Long getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(Long goodsID) {
		this.goodsID = goodsID;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
