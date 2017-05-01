package com.hmsh.app.vo.order;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-05-01 21:18:30
 * @version 1.0.0
 */
@Table(name = "order_goods")
public class OrderGoods extends BaseEntity<Long> {
	// 主键;
	@Id
	private Long dmid;

	// 订单id
	@NotEmpty(message = "orderId不能为空!")
	private Long orderid;

	// 商品名字
	private String goodsname;

	// 单个商品数量
	@NotEmpty(message = "goodsNum不能为空!")
	private Integer goodsnum;

	// 商品总额
	private BigDecimal goodstotalprice;

	// 商品单价
	private BigDecimal goodsprice;

	// 商品id
	private Long goodsid;

	// skuId
	private Long skuid;

	// 冗余主图
	private String imgs;

	// 该商品优惠券抵扣金额部分
	private BigDecimal coupontotalprice;

	// 该商品积分抵扣金额部分
	private BigDecimal deductiontotalprice;

	// 该商品积分赠送金额部分
	private BigDecimal returntotalprice;

	// 退款状态,参考枚举
	private Integer refundstatus;

	private static final long serialVersionUID = 1L;

	public Long getDmid() {
		return dmid;
	}

	public void setDmid(Long dmid) {
		this.dmid = dmid;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Integer getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}

	public BigDecimal getGoodstotalprice() {
		return goodstotalprice;
	}

	public void setGoodstotalprice(BigDecimal goodstotalprice) {
		this.goodstotalprice = goodstotalprice;
	}

	public BigDecimal getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(BigDecimal goodsprice) {
		this.goodsprice = goodsprice;
	}

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getSkuid() {
		return skuid;
	}

	public void setSkuid(Long skuid) {
		this.skuid = skuid;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public BigDecimal getCoupontotalprice() {
		return coupontotalprice;
	}

	public void setCoupontotalprice(BigDecimal coupontotalprice) {
		this.coupontotalprice = coupontotalprice;
	}

	public BigDecimal getDeductiontotalprice() {
		return deductiontotalprice;
	}

	public void setDeductiontotalprice(BigDecimal deductiontotalprice) {
		this.deductiontotalprice = deductiontotalprice;
	}

	public BigDecimal getReturntotalprice() {
		return returntotalprice;
	}

	public void setReturntotalprice(BigDecimal returntotalprice) {
		this.returntotalprice = returntotalprice;
	}

	public Integer getRefundstatus() {
		return refundstatus;
	}

	public void setRefundstatus(Integer refundstatus) {
		this.refundstatus = refundstatus;
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