package com.hmsh.app.vo.wms;

import java.util.ArrayList;
import java.util.List;

import com.hmsh.core.base.vo.BaseEntity;
/**
 * 商品发货单信息
 * @author leichao
 *
 */
public class StorageInfo extends BaseEntity<Long>{
	
	private static final long serialVersionUID = 8930428463141868748L;
	
	private Long id;
	/**
	 * skuID
	 */
	private Long skuID;
	/**
	 * 附属字段商品名称
	 */
	private String goodsName;
	/**
	 * 附属字段商品主图
	 */
	private String goodsImg;
	/**
	 * 商品ID
	 */
	private Long goodsID;
	/**
	 * 数量
	 */
	private Long num;
	/**
	 * 发货单编码
	 */
	private Long storageNo;
	
    private List<GoodsSkuInfo> goodsSkuInfos=new ArrayList<>();
    
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public List<GoodsSkuInfo> getGoodsSkuInfos() {
		return goodsSkuInfos;
	}
	public void setGoodsSkuInfos(List<GoodsSkuInfo> goodsSkuInfos) {
		this.goodsSkuInfos = goodsSkuInfos;
	}
	public Long getStorageNo() {
		return storageNo;
	}
	public void setStorageNo(Long storageNo) {
		this.storageNo = storageNo;
	}
	public Long getSkuID() {
		return skuID;
	}
	public void setSkuID(Long skuID) {
		this.skuID = skuID;
	}
	public Long getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(Long goodsID) {
		this.goodsID = goodsID;
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
