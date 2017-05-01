package com.hmsh.admin.vo.wms;

import java.math.BigDecimal;

import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-26 09:44:15
 * @version 1.0.0
 */
@Table(name="wms_goods_sku_info")
public class GoodsSkuInfo extends BaseEntity<Long> {
    // 
    @NotEmpty(message="id不能为空!")
    private Long id;

    // 商品名称
    private String goodsname;

    // 商品ID
    @NotEmpty(message="goodsID不能为空!")
    private Long goodsid;

    // 零售价
    private BigDecimal retailprice;

    // 市场价
    private BigDecimal marketprice;

    // 成本价
    private BigDecimal costprice;

    // 最小单位
    private String unit;

    // 体积（单位为㎡
    private String volume;

    // 重量（单位为g）
    private BigDecimal weight;

    // 类型
    private String type;

    // 尺寸 尺码
    private Long size;

    // 颜色
    private String specification;

    // 保质期(天)
    private Long shelflifeperiod;

    // 出厂日期
    private Long dateofproduction;

    // 消费者返现比例
    private BigDecimal custmrrebateratio;

    // 商家返现比例
    private BigDecimal shopprofitratio;

    // 供应商返现比例
    private BigDecimal supplyrebateratio;

    // 省级代理返现比例
    private BigDecimal rebateprovince;

    // 市级代理返现比例
    private BigDecimal rebatecity;

    // 县级代理返现比例
    private BigDecimal rebatearea;

    // 商品简介
    private String intro;

    // 税率
    private BigDecimal taxrate;

    // 
    private String spec;

    // 
    private String value;

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

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public BigDecimal getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(BigDecimal retailprice) {
        this.retailprice = retailprice;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Long getShelflifeperiod() {
        return shelflifeperiod;
    }

    public void setShelflifeperiod(Long shelflifeperiod) {
        this.shelflifeperiod = shelflifeperiod;
    }

    public Long getDateofproduction() {
        return dateofproduction;
    }

    public void setDateofproduction(Long dateofproduction) {
        this.dateofproduction = dateofproduction;
    }

    public BigDecimal getCustmrrebateratio() {
        return custmrrebateratio;
    }

    public void setCustmrrebateratio(BigDecimal custmrrebateratio) {
        this.custmrrebateratio = custmrrebateratio;
    }

    public BigDecimal getShopprofitratio() {
        return shopprofitratio;
    }

    public void setShopprofitratio(BigDecimal shopprofitratio) {
        this.shopprofitratio = shopprofitratio;
    }

    public BigDecimal getSupplyrebateratio() {
        return supplyrebateratio;
    }

    public void setSupplyrebateratio(BigDecimal supplyrebateratio) {
        this.supplyrebateratio = supplyrebateratio;
    }

    public BigDecimal getRebateprovince() {
        return rebateprovince;
    }

    public void setRebateprovince(BigDecimal rebateprovince) {
        this.rebateprovince = rebateprovince;
    }

    public BigDecimal getRebatecity() {
        return rebatecity;
    }

    public void setRebatecity(BigDecimal rebatecity) {
        this.rebatecity = rebatecity;
    }

    public BigDecimal getRebatearea() {
        return rebatearea;
    }

    public void setRebatearea(BigDecimal rebatearea) {
        this.rebatearea = rebatearea;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}