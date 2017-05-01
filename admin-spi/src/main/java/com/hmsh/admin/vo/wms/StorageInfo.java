package com.hmsh.admin.vo.wms;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-26 09:44:31
 * @version 1.0.0
 */
@Table(name="wms_storage_info")
public class StorageInfo extends BaseEntity<Long> {
    // 主键; 出库单信息dmId
    @Id
    private Long id;

    // skuID
    @NotEmpty(message="skuID不能为空!")
    private Long skuid;

    // 商品ID
    @NotEmpty(message="goodsID不能为空!")
    private Long goodsid;

    // 数量
    @NotEmpty(message="num不能为空!")
    private Long num;

    // 发货单编码
    private Long storageno;

    // 商品名称
    private String goodsname;

    // 商品主图
    private String goodsimg;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuid() {
        return skuid;
    }

    public void setSkuid(Long skuid) {
        this.skuid = skuid;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getStorageno() {
        return storageno;
    }

    public void setStorageno(Long storageno) {
        this.storageno = storageno;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }
}