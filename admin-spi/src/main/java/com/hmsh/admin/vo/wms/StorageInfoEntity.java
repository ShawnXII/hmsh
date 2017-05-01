package com.hmsh.admin.vo.wms;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @ClassName StorageInfoEntity
 * @Description 出库单信息
 * @author ShawnXII
 * @date 2017-04-22 16:08:41
 * @version 1.0 
 */
public class StorageInfoEntity extends BaseEntity<Long>{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3321231903191703950L;
	//出库单信息dmId
    private Long id;
    //skuID
    private Long skuID;
    //商品ID
    private Long goodsID;
    //数量
    private Long num;
    //发货单编码
    private Long storageNo;
    //商品名称
    private String goodsName;
    //商品主图
    private String goodsImg;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Long getStorageNo() {
        return storageNo;
    }
    public void setStorageNo(Long storageNo) {
        this.storageNo = storageNo;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getGoodsImg() {
        return goodsImg;
    }
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

}