package com.hmsh.app.vo.order;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:18:23
 * @version 1.0.0
 */
@Table(name="order")
public class Order extends BaseEntity<Long> {
    // 主键; 订单id
    @Id
    private Long dmid;

    // 商家id
    @NotEmpty(message="sellerId不能为空!")
    private Long sellerid;

    // 使用优惠卷 没有 则为null
    private Long couponid;

    // 购买用户
    @NotEmpty(message="userId不能为空!")
    private Long userid;

    // 创建时间 下单时间
    private Long crtime;

    // 1 外卖订单 2 堂食订单
    @NotEmpty(message="orderType不能为空!")
    private Integer ordertype;

    // 支付成功时间
    private Long chargetime;

    // 订单状态
    @NotEmpty(message="orderStatus不能为空!")
    private Integer orderstatus;

    // 第三方流水号
    private String threeserialnumber;

    // 订单商品总价
    @NotEmpty(message="orderPrice不能为空!")
    private BigDecimal orderprice;

    // 优惠券抵扣金额
    @NotEmpty(message="couponPrice不能为空!")
    private BigDecimal couponprice;

    // 积分抵扣金额
    @NotEmpty(message="deductionPrice不能为空!")
    private BigDecimal deductionprice;

    // 派送费
    @NotEmpty(message="sendFee不能为空!")
    private BigDecimal sendfee;

    // 餐盒费
    @NotEmpty(message="mealFee不能为空!")
    private BigDecimal mealfee;

    // 付款金额
    @NotEmpty(message="paymentPrice不能为空!")
    private BigDecimal paymentprice;

    // 收货人身份证(海外商品订单才填入)
    private String receivingpno;

    // 收货手机号码
    private String receivingphone;

    // 收货名字
    private String receivingname;

    // 收货地址所在区一级ID
    private Integer countyid;

    // 门牌号
    private String housenumber;

    // 收货地址
    private String receivingaddress;

    // 商品总数量
    private Integer goodscount;

    // 支付状态 0支付成功 1 未支付
    private Integer paystatus;

    // 预约开始时间
    private Long maketime;

    // 交易状态 0交易成功 1 交易失败   2默认交易中
    private Integer transactionstatus;

    // 收货状态  0 未收货  1 已收货
    private Integer receivingstatus;

    // 退款状态 0 未申请退款  1申请退款 2同意退款 3拒绝退款
    private Integer refundstatus;

    // 接单状态 0已接单  1 未接单  2拒绝接单
    private Integer sellerorderstatus;

    // 备注
    private String note;

    // 支付类型 参考代码
    private Integer paytype;

    //  退款备注
    private String refundnote;

    // 点评状态,0:未评论,1:已评论
    private Integer reviews;

    // 是否自营商城订单:0,是，1否
    @NotEmpty(message="forVipMall不能为空!")
    private Integer forvipmall;

    private static final long serialVersionUID = 1L;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public Long getSellerid() {
        return sellerid;
    }

    public void setSellerid(Long sellerid) {
        this.sellerid = sellerid;
    }

    public Long getCouponid() {
        return couponid;
    }

    public void setCouponid(Long couponid) {
        this.couponid = couponid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCrtime() {
        return crtime;
    }

    public void setCrtime(Long crtime) {
        this.crtime = crtime;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Long getChargetime() {
        return chargetime;
    }

    public void setChargetime(Long chargetime) {
        this.chargetime = chargetime;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getThreeserialnumber() {
        return threeserialnumber;
    }

    public void setThreeserialnumber(String threeserialnumber) {
        this.threeserialnumber = threeserialnumber;
    }

    public BigDecimal getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(BigDecimal orderprice) {
        this.orderprice = orderprice;
    }

    public BigDecimal getCouponprice() {
        return couponprice;
    }

    public void setCouponprice(BigDecimal couponprice) {
        this.couponprice = couponprice;
    }

    public BigDecimal getDeductionprice() {
        return deductionprice;
    }

    public void setDeductionprice(BigDecimal deductionprice) {
        this.deductionprice = deductionprice;
    }

    public BigDecimal getSendfee() {
        return sendfee;
    }

    public void setSendfee(BigDecimal sendfee) {
        this.sendfee = sendfee;
    }

    public BigDecimal getMealfee() {
        return mealfee;
    }

    public void setMealfee(BigDecimal mealfee) {
        this.mealfee = mealfee;
    }

    public BigDecimal getPaymentprice() {
        return paymentprice;
    }

    public void setPaymentprice(BigDecimal paymentprice) {
        this.paymentprice = paymentprice;
    }

    public String getReceivingpno() {
        return receivingpno;
    }

    public void setReceivingpno(String receivingpno) {
        this.receivingpno = receivingpno;
    }

    public String getReceivingphone() {
        return receivingphone;
    }

    public void setReceivingphone(String receivingphone) {
        this.receivingphone = receivingphone;
    }

    public String getReceivingname() {
        return receivingname;
    }

    public void setReceivingname(String receivingname) {
        this.receivingname = receivingname;
    }

    public Integer getCountyid() {
        return countyid;
    }

    public void setCountyid(Integer countyid) {
        this.countyid = countyid;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getReceivingaddress() {
        return receivingaddress;
    }

    public void setReceivingaddress(String receivingaddress) {
        this.receivingaddress = receivingaddress;
    }

    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public Long getMaketime() {
        return maketime;
    }

    public void setMaketime(Long maketime) {
        this.maketime = maketime;
    }

    public Integer getTransactionstatus() {
        return transactionstatus;
    }

    public void setTransactionstatus(Integer transactionstatus) {
        this.transactionstatus = transactionstatus;
    }

    public Integer getReceivingstatus() {
        return receivingstatus;
    }

    public void setReceivingstatus(Integer receivingstatus) {
        this.receivingstatus = receivingstatus;
    }

    public Integer getRefundstatus() {
        return refundstatus;
    }

    public void setRefundstatus(Integer refundstatus) {
        this.refundstatus = refundstatus;
    }

    public Integer getSellerorderstatus() {
        return sellerorderstatus;
    }

    public void setSellerorderstatus(Integer sellerorderstatus) {
        this.sellerorderstatus = sellerorderstatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public String getRefundnote() {
        return refundnote;
    }

    public void setRefundnote(String refundnote) {
        this.refundnote = refundnote;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Integer getForvipmall() {
        return forvipmall;
    }

    public void setForvipmall(Integer forvipmall) {
        this.forvipmall = forvipmall;
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