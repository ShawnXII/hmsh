package com.hmsh.app.vo.user;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:25:23
 * @version 1.0.0
 */
@Table(name="uw_wallet_exchange_apply")
public class UwWalletExchangeApply extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long dmid;

    // 用户
    private Long userid;

    // 积分接收用户
    private Long acceptorid;

    // 用户类型
    private Byte usertype;

    // 当前余额
    private BigDecimal currentbalance;

    // 申请金额
    private BigDecimal amount;

    // 兑换类型 1 payable 2 wallet
    private Byte exchangetype;

    // 申请状态 申请中 申请通过 不通过 复核通过 不通过
    private Byte status;

    // 
    private Long createtime;

    // 
    private Long createby;

    // 
    private Long updateby;

    // 
    private Long updatetime;

    // 备注
    private String remark;

    // 凭证
    private String voucher;

    // 兑换钱包类型
    private Byte fromwallettype;

    // 接收类型
    private Byte towallettype;

    // action备注
    private String actionremark;

    // 关联提现单号
    private Long withdrawid;

    // 第一次复核时间
    private Long verifytime;

    // 第二次复核时间
    private Long reverifytime;

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

    public Long getAcceptorid() {
        return acceptorid;
    }

    public void setAcceptorid(Long acceptorid) {
        this.acceptorid = acceptorid;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public BigDecimal getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(BigDecimal currentbalance) {
        this.currentbalance = currentbalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getExchangetype() {
        return exchangetype;
    }

    public void setExchangetype(Byte exchangetype) {
        this.exchangetype = exchangetype;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public Long getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Long updateby) {
        this.updateby = updateby;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public Byte getFromwallettype() {
        return fromwallettype;
    }

    public void setFromwallettype(Byte fromwallettype) {
        this.fromwallettype = fromwallettype;
    }

    public Byte getTowallettype() {
        return towallettype;
    }

    public void setTowallettype(Byte towallettype) {
        this.towallettype = towallettype;
    }

    public String getActionremark() {
        return actionremark;
    }

    public void setActionremark(String actionremark) {
        this.actionremark = actionremark;
    }

    public Long getWithdrawid() {
        return withdrawid;
    }

    public void setWithdrawid(Long withdrawid) {
        this.withdrawid = withdrawid;
    }

    public Long getVerifytime() {
        return verifytime;
    }

    public void setVerifytime(Long verifytime) {
        this.verifytime = verifytime;
    }

    public Long getReverifytime() {
        return reverifytime;
    }

    public void setReverifytime(Long reverifytime) {
        this.reverifytime = reverifytime;
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