package com.hmsh.admin.vo.wms;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @ClassName GoodsInfoEntity
 * @Description 商品信息
 * @author ShawnXII
 * @date 2017-04-22 16:08:41
 * @version 1.0 
 */
public class GoodsInfoEntity extends BaseEntity<Long>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1093109532711141L;
	private Long id;
    //商品名称
    private String goodsName;
    //商品主图
    private String image;
    private Long goodsID;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Long getGoodsID() {
        return goodsID;
    }
    public void setGoodsID(Long goodsID) {
        this.goodsID = goodsID;
    }

}