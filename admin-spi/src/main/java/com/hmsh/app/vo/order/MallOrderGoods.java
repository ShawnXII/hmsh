package com.hmsh.app.vo.order;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-05-01 21:18:15
 * @version 1.0.0
 */
@Table(name = "mall_order_goods")
public class MallOrderGoods extends BaseEntity<Long> {
	// 主键; 商城订单商品ID
	@Id
	private Long dmid;

	// 商城订单ID
	@NotEmpty(message = "mallOrderId不能为空!")
	private Long mallorderid;

	// 商品名称
	@NotEmpty(message = "goodsName不能为空!")
	private String goodsname;

	// 商品SKU
	@NotEmpty(message = "goodsSkuId不能为空!")
	private Long goodsskuid;

	// 下单数量
	@NotEmpty(message = "goodsNum不能为空!")
	private Integer goodsnum;

	// 销售单价
	@NotEmpty(message = "goodsPrice不能为空!")
	private BigDecimal goodsprice;

	// 进货单价
	@NotEmpty(message = "purchasePrice不能为空!")
	private BigDecimal purchaseprice;

	// 图片地址
	private String imgurl;

	private static final long serialVersionUID = 1L;

	public Long getDmid() {
		return dmid;
	}

	public void setDmid(Long dmid) {
		this.dmid = dmid;
	}

	public Long getMallorderid() {
		return mallorderid;
	}

	public void setMallorderid(Long mallorderid) {
		this.mallorderid = mallorderid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Long getGoodsskuid() {
		return goodsskuid;
	}

	public void setGoodsskuid(Long goodsskuid) {
		this.goodsskuid = goodsskuid;
	}

	public Integer getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}

	public BigDecimal getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(BigDecimal goodsprice) {
		this.goodsprice = goodsprice;
	}

	public BigDecimal getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(BigDecimal purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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