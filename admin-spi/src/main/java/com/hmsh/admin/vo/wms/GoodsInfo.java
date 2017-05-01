package com.hmsh.admin.vo.wms;

import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-26 09:44:04
 * @version 1.0.0
 */
@Table(name="wms_goods_info")
public class GoodsInfo extends BaseEntity<Long>{
    // 主键; 
    @Id
    private Long id;

    // 商品名称
    private String goodsname;

    // 商品主图
    private String image;

    // 
    private Long goodsid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
}