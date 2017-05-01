package com.hmsh.app.vo.order;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:18:08
 * @version 1.0.0
 */
@Table(name="mall_order")
public class MallOrder extends BaseEntity<Long> {
    // 主键; 子订单ID(根据供应商拆单了叫做子订单)
    @Id
    private Long dmid;

    // 原订单号
    @NotEmpty(message="orderId不能为空!")
    private Long orderid;

    // 商城供应商ID
    @NotEmpty(message="mallSupplierId不能为空!")
    private Long mallsupplierid;

    // 子订单总额
    @NotEmpty(message="partPrice不能为空!")
    private BigDecimal partprice;

    // 子订单进货价总额
    @NotEmpty(message="supplyPrice不能为空!")
    private BigDecimal supplyprice;

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

    public Long getMallsupplierid() {
        return mallsupplierid;
    }

    public void setMallsupplierid(Long mallsupplierid) {
        this.mallsupplierid = mallsupplierid;
    }

    public BigDecimal getPartprice() {
        return partprice;
    }

    public void setPartprice(BigDecimal partprice) {
        this.partprice = partprice;
    }

    public BigDecimal getSupplyprice() {
        return supplyprice;
    }

    public void setSupplyprice(BigDecimal supplyprice) {
        this.supplyprice = supplyprice;
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