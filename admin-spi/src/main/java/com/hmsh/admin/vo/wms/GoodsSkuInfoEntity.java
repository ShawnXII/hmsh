package com.hmsh.admin.vo.wms;

import java.math.BigDecimal;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @ClassName GoodsSkuInfoEntity
 * @Description sku信息
 * @author ShawnXII
 * @date 2017-04-22 16:08:41
 * @version 1.0 
 */
public class GoodsSkuInfoEntity extends BaseEntity<Long>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1962733076736332914L;
	private Long id;
    //商品名称
    private String goodsName;
    //商品ID
    private Long goodsID;
    //零售价
    private BigDecimal retailPrice;
    //市场价
    private BigDecimal marketPrice;
    //成本价
    private BigDecimal costPrice;
    //最小单位
    private String unit;
    //体积（单位为㎡
    private String volume;
    //重量（单位为g）
    private BigDecimal weight;
    //类型
    private String type;
    //尺寸 尺码
    private Long size;
    //颜色
    private String specification;
    //保质期(天)
    private Long shelfLifePeriod;
    //出厂日期
    private Long dateOfProduction;
    //消费者返现比例
    private BigDecimal custmrRebateRatio;
    //商家返现比例
    private BigDecimal shopProfitRatio;
    //供应商返现比例
    private BigDecimal supplyRebateRatio;
    //省级代理返现比例
    private BigDecimal rebateProvince;
    //市级代理返现比例
    private BigDecimal rebateCity;
    //县级代理返现比例
    private BigDecimal rebateArea;
    //商品简介
    private String intro;
    //税率
    private BigDecimal taxRate;
    private String spec;
    private String value;

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
    public Long getGoodsID() {
        return goodsID;
    }
    public void setGoodsID(Long goodsID) {
        this.goodsID = goodsID;
    }
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }
    public BigDecimal getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
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
    public Long getShelfLifePeriod() {
        return shelfLifePeriod;
    }
    public void setShelfLifePeriod(Long shelfLifePeriod) {
        this.shelfLifePeriod = shelfLifePeriod;
    }
    public Long getDateOfProduction() {
        return dateOfProduction;
    }
    public void setDateOfProduction(Long dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }
    public BigDecimal getCustmrRebateRatio() {
        return custmrRebateRatio;
    }
    public void setCustmrRebateRatio(BigDecimal custmrRebateRatio) {
        this.custmrRebateRatio = custmrRebateRatio;
    }
    public BigDecimal getShopProfitRatio() {
        return shopProfitRatio;
    }
    public void setShopProfitRatio(BigDecimal shopProfitRatio) {
        this.shopProfitRatio = shopProfitRatio;
    }
    public BigDecimal getSupplyRebateRatio() {
        return supplyRebateRatio;
    }
    public void setSupplyRebateRatio(BigDecimal supplyRebateRatio) {
        this.supplyRebateRatio = supplyRebateRatio;
    }
    public BigDecimal getRebateProvince() {
        return rebateProvince;
    }
    public void setRebateProvince(BigDecimal rebateProvince) {
        this.rebateProvince = rebateProvince;
    }
    public BigDecimal getRebateCity() {
        return rebateCity;
    }
    public void setRebateCity(BigDecimal rebateCity) {
        this.rebateCity = rebateCity;
    }
    public BigDecimal getRebateArea() {
        return rebateArea;
    }
    public void setRebateArea(BigDecimal rebateArea) {
        this.rebateArea = rebateArea;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
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