package com.hmsh.app.vo.user;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-05-01 21:25:09
 * @version 1.0.0
 */
@Table(name = "uw_userwallet")
public class Userwallet extends BaseEntity<Long> {
	// 主键; 主键ID
	@Id
	private Long dmid;

	// 用户ID
	private Long userid;

	// 用户类型
	private Short usertype;

	// 分润总额
	private BigDecimal runsubtotalamount;

	// 退款总额
	private BigDecimal reimbursetotalamount;

	// 对账中总额
	private BigDecimal reconciliationtotalamount;

	// 返现总额
	private BigDecimal cashbacktotalamount;

	// 货款总额
	private BigDecimal goodstotalamount;

	// 金币总额
	private BigDecimal goldtotalamount;

	// 创建人
	private Long createby;

	// 创建时间
	private Date createon;

	// 更新人
	private Long updateby;

	// 更新时间
	private Date updateon;

	// 支付密码
	private String paypwd;

	// 可消费补贴总额
	private BigDecimal consumetotalamount;

	// 海淘补贴总额
	private BigDecimal htsubsidytotalamount;

	// 商家消费保障金余额
	private BigDecimal cashdeposittotalamount;

	// 消费保障金使用密码
	private String depositpwd;

	private static final long serialVersionUID = 1L;

	public Long getDmid() {
		return dmid;
	}

	public void setDmid(Long dmid) {
		this.dmid = dmid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Short getUsertype() {
		return usertype;
	}

	public void setUsertype(Short usertype) {
		this.usertype = usertype;
	}

	public BigDecimal getRunsubtotalamount() {
		return runsubtotalamount;
	}

	public void setRunsubtotalamount(BigDecimal runsubtotalamount) {
		this.runsubtotalamount = runsubtotalamount;
	}

	public BigDecimal getReimbursetotalamount() {
		return reimbursetotalamount;
	}

	public void setReimbursetotalamount(BigDecimal reimbursetotalamount) {
		this.reimbursetotalamount = reimbursetotalamount;
	}

	public BigDecimal getReconciliationtotalamount() {
		return reconciliationtotalamount;
	}

	public void setReconciliationtotalamount(BigDecimal reconciliationtotalamount) {
		this.reconciliationtotalamount = reconciliationtotalamount;
	}

	public BigDecimal getCashbacktotalamount() {
		return cashbacktotalamount;
	}

	public void setCashbacktotalamount(BigDecimal cashbacktotalamount) {
		this.cashbacktotalamount = cashbacktotalamount;
	}

	public BigDecimal getGoodstotalamount() {
		return goodstotalamount;
	}

	public void setGoodstotalamount(BigDecimal goodstotalamount) {
		this.goodstotalamount = goodstotalamount;
	}

	public BigDecimal getGoldtotalamount() {
		return goldtotalamount;
	}

	public void setGoldtotalamount(BigDecimal goldtotalamount) {
		this.goldtotalamount = goldtotalamount;
	}

	public Long getCreateby() {
		return createby;
	}

	public void setCreateby(Long createby) {
		this.createby = createby;
	}

	public Date getCreateon() {
		return createon;
	}

	public void setCreateon(Date createon) {
		this.createon = createon;
	}

	public Long getUpdateby() {
		return updateby;
	}

	public void setUpdateby(Long updateby) {
		this.updateby = updateby;
	}

	public Date getUpdateon() {
		return updateon;
	}

	public void setUpdateon(Date updateon) {
		this.updateon = updateon;
	}

	public String getPaypwd() {
		return paypwd;
	}

	public void setPaypwd(String paypwd) {
		this.paypwd = paypwd;
	}

	public BigDecimal getConsumetotalamount() {
		return consumetotalamount;
	}

	public void setConsumetotalamount(BigDecimal consumetotalamount) {
		this.consumetotalamount = consumetotalamount;
	}

	public BigDecimal getHtsubsidytotalamount() {
		return htsubsidytotalamount;
	}

	public void setHtsubsidytotalamount(BigDecimal htsubsidytotalamount) {
		this.htsubsidytotalamount = htsubsidytotalamount;
	}

	public BigDecimal getCashdeposittotalamount() {
		return cashdeposittotalamount;
	}

	public void setCashdeposittotalamount(BigDecimal cashdeposittotalamount) {
		this.cashdeposittotalamount = cashdeposittotalamount;
	}

	public String getDepositpwd() {
		return depositpwd;
	}

	public void setDepositpwd(String depositpwd) {
		this.depositpwd = depositpwd;
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