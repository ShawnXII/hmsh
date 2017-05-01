package com.hmsh.app.vo.goods;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:06:34
 * @version 1.0.0
 */
@Table(name="novel_goods_sku")
public class GoodsSku extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long dmid;

    // 商品名称
    @NotEmpty(message="name不能为空!")
    private String name;

    // 零售价
    @NotEmpty(message="price不能为空!")
    private BigDecimal price;

    // 市场价
    private BigDecimal marketprice;

    // 供应链仓储的商品编号(如果不为null,则为自营商品)
    private String scmgoodsid;

    // 备注
    private String remarks;

    // 状态 0:创建并上架 1:下架  
    @NotEmpty(message="state不能为空!")
    private Integer state;

    // 是否支持优惠券 0:支持 1:不支持
    private Integer iscoupon;

    // 创建人
    private String createby;

    // 创建时间
    private Long createtime;

    // 最后一次更新人
    private String updateby;

    // 更新时间
    private Long updatetime;

    // 主商品ID
    @NotEmpty(message="goodsId不能为空!")
    private Long goodsid;

    // 体积
    private String volume;

    // 重量(计量单位:公斤)
    private BigDecimal weight;

    // 消费者返利
    private BigDecimal rebateconsumers;

    // 返商家
    private BigDecimal rebateseller;

    // 返供应链
    private BigDecimal rebatesupply;

    // 返代理商(县)
    private BigDecimal rebateprovince;

    // 返代理商(市)
    private BigDecimal rebatecity;

    // 返代理商(县/区)
    private BigDecimal rebatearea;

    // 
    private BigDecimal purchaseprice;

    // 主图(搜索展示图)
    private String mainimage;

    // 
    private String details;

    // 是否VIP商城商品0,是，1否
    private Integer forvipmall;

    // 现金消费返积分比例
    private BigDecimal returnpointpercent;

    // 积分消费抵扣百分比
    private BigDecimal deductpricepercent;

    private static final long serialVersionUID = 1L;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public String getScmgoodsid() {
        return scmgoodsid;
    }

    public void setScmgoodsid(String scmgoodsid) {
        this.scmgoodsid = scmgoodsid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIscoupon() {
        return iscoupon;
    }

    public void setIscoupon(Integer iscoupon) {
        this.iscoupon = iscoupon;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
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

    public BigDecimal getRebateconsumers() {
        return rebateconsumers;
    }

    public void setRebateconsumers(BigDecimal rebateconsumers) {
        this.rebateconsumers = rebateconsumers;
    }

    public BigDecimal getRebateseller() {
        return rebateseller;
    }

    public void setRebateseller(BigDecimal rebateseller) {
        this.rebateseller = rebateseller;
    }

    public BigDecimal getRebatesupply() {
        return rebatesupply;
    }

    public void setRebatesupply(BigDecimal rebatesupply) {
        this.rebatesupply = rebatesupply;
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

    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public String getMainimage() {
        return mainimage;
    }

    public void setMainimage(String mainimage) {
        this.mainimage = mainimage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getForvipmall() {
        return forvipmall;
    }

    public void setForvipmall(Integer forvipmall) {
        this.forvipmall = forvipmall;
    }

    public BigDecimal getReturnpointpercent() {
        return returnpointpercent;
    }

    public void setReturnpointpercent(BigDecimal returnpointpercent) {
        this.returnpointpercent = returnpointpercent;
    }

    public BigDecimal getDeductpricepercent() {
        return deductpricepercent;
    }

    public void setDeductpricepercent(BigDecimal deductpricepercent) {
        this.deductpricepercent = deductpricepercent;
    }

	@Override
	public void setId(Long id) {
		this.setDmid(id);
	}

	@Override
	public Long getId() {
		return this.getDmid();
	}
}