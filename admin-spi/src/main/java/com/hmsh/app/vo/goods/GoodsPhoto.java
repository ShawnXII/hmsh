package com.hmsh.app.vo.goods;

import java.io.Serializable;

import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:09:48
 * @version 1.0.0
 */
@Table(name="novel_goods_photo")
public class GoodsPhoto implements Serializable {
    // 
    @NotEmpty(message="path不能为空!")
    private String path;

    // 图片类型 0:描述图
    private Integer type;

    // 序号 越小越靠前
    private Integer sequence;

    // 商品SKUID
    private Long goodsskuid;

    // 商品主表ID
    private Long goodsid;

    private static final long serialVersionUID = 1L;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getGoodsskuid() {
        return goodsskuid;
    }

    public void setGoodsskuid(Long goodsskuid) {
        this.goodsskuid = goodsskuid;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
}