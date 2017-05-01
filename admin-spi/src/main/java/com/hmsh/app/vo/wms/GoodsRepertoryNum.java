package com.hmsh.app.vo.wms;

import com.hmsh.core.base.vo.BaseEntity;
/**
 * 商品库存数量
 * @author leichao
 *
 */
public class GoodsRepertoryNum  extends BaseEntity<Long>{

	private static final long serialVersionUID = -4840906862877469529L;
	private Long id;
	/**
	 * skuID 
	 */
	private Long skuID;	
	/**
	 * 数量
	 */
	private Long num;
	
	public Long getSkuID() {
		return skuID;
	}
	public void setSkuID(Long skuID) {
		this.skuID = skuID;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
