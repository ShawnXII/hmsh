package com.hmsh.app.vo.goods;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-05-01 21:06:26
 * @version 1.0.0
 */
@Table(name = "novel_goods")
public class Goods extends BaseEntity<Long> {
	// 主键;
	@Id
	private Long dmid;

	// 商城供应商ID
	private Long mallsupplierid;

	// 商品名称
	@NotEmpty(message = "name不能为空!")
	private String name;

	// 零售价
	@NotEmpty(message = "price不能为空!")
	private BigDecimal price;

	// 市场价
	private BigDecimal marketprice;

	// 供应链仓储的商品编号(如果不为null,则为自营商品)
	private String scmgoodsid;

	// 备注
	private String remarks;

	// 分类ID
	@NotEmpty(message = "goodsClassId不能为空!")
	private Long goodsclassid;

	// 商品属性类型 0:虚拟商品 1:商品(默认)
	private Integer type;

	// 状态 0:创建并上架 1:下架
	@NotEmpty(message = "state不能为空!")
	private Integer state;

	// 是否支持优惠券 0:支持 1:不支持
	private Integer iscoupon;

	// 限量 小于等于0表示不限量
	private Integer limited;

	// 单位
	private String unit;

	// 单位ID
	private Long unitid;

	// 分类名称
	private String goodsclassname;

	// 商品类型 0:普通商家商品(默认) 1:商城商品 2 粮票兑换商品
	private Integer goodstype;

	// 体积
	private String volume;

	// 重量(计量单位:公斤)
	private BigDecimal weight;

	//
	private String createby;

	//
	private Long createtime;

	//
	private String updateby;

	//
	private Long updatetime;

	// 销量
	private Integer salesvolume;

	// 成本价
	private BigDecimal purchaseprice;

	// 保质期
	private Integer shelflifeperiod;

	// 是否国外商品:0是1否
	private Integer isforeign;

	private static final long serialVersionUID = 1L;

	public Long getDmid() {
		return dmid;
	}

	public void setDmid(Long dmid) {
		this.dmid = dmid;
	}

	public Long getMallsupplierid() {
		return mallsupplierid;
	}

	public void setMallsupplierid(Long mallsupplierid) {
		this.mallsupplierid = mallsupplierid;
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

	public Long getGoodsclassid() {
		return goodsclassid;
	}

	public void setGoodsclassid(Long goodsclassid) {
		this.goodsclassid = goodsclassid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Integer getLimited() {
		return limited;
	}

	public void setLimited(Integer limited) {
		this.limited = limited;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getUnitid() {
		return unitid;
	}

	public void setUnitid(Long unitid) {
		this.unitid = unitid;
	}

	public String getGoodsclassname() {
		return goodsclassname;
	}

	public void setGoodsclassname(String goodsclassname) {
		this.goodsclassname = goodsclassname;
	}

	public Integer getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(Integer goodstype) {
		this.goodstype = goodstype;
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

	public Integer getSalesvolume() {
		return salesvolume;
	}

	public void setSalesvolume(Integer salesvolume) {
		this.salesvolume = salesvolume;
	}

	public BigDecimal getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(BigDecimal purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public Integer getShelflifeperiod() {
		return shelflifeperiod;
	}

	public void setShelflifeperiod(Integer shelflifeperiod) {
		this.shelflifeperiod = shelflifeperiod;
	}

	public Integer getIsforeign() {
		return isforeign;
	}

	public void setIsforeign(Integer isforeign) {
		this.isforeign = isforeign;
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