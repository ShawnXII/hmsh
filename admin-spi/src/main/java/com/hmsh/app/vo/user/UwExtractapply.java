package com.hmsh.app.vo.user;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:26:47
 * @version 1.0.0
 */
@Table(name="uw_extractapply")
public class UwExtractapply extends BaseEntity<Long> {
    // 主键; 主键ID
    @Id
    private Long dmid;

    // 源单类型(0：表示货款提现，1：平台分润提现，2：表示代理商分润提现，3：商家分润提现，4：个人分润提现，5：返现提现，6：退款提现)
    private Short sourcetype;

    // 申请日期
    private Date applytime;

    // 提现用户
    private Long userid;

    // 提现金额
    private BigDecimal amount;

    // 收款银行
    private String bankname;

    // 支行名称
    private String bankbranch;

    // 收款卡号
    private String bankno;

    // 持卡人名字
    private String cardholdername;

    // 状态(0：表示对账中，1：表示已提现，2：表示驳回，3：表示取消,4:追回)
    private Byte status;

    // 创建人
    private String createby;

    // 创建时间
    private Long createon;

    // 处理人
    private Long dealby;

    // 处理时间
    private Date dealon;

    // 处理备注
    private String dealremark;

    // 更新人
    private Long updateby;

    // 更新时间
    private Date updateon;

    // 创建日期(日期类型)
    private Date statisticsdate;

    // 用户类型
    private Byte usertype;

    // 解冻时间
    private Long releasedate;

    // 预计到账金额
    @Column(name="arrival_amount")
    private BigDecimal arrivalAmount;

    // 税务扣点税率
    @Column(name="tax_dedu_rate")
    private BigDecimal taxDeduRate;

    // 扣税金额
    @Column(name="tax_dedu_money")
    private BigDecimal taxDeduMoney;

    // 源单ID
    @Column(name="single_source_id")
    private Long singleSourceId;

    // 
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public Short getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(Short sourcetype) {
        this.sourcetype = sourcetype;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankbranch() {
        return bankbranch;
    }

    public void setBankbranch(String bankbranch) {
        this.bankbranch = bankbranch;
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno;
    }

    public String getCardholdername() {
        return cardholdername;
    }

    public void setCardholdername(String cardholdername) {
        this.cardholdername = cardholdername;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Long getCreateon() {
        return createon;
    }

    public void setCreateon(Long createon) {
        this.createon = createon;
    }

    public Long getDealby() {
        return dealby;
    }

    public void setDealby(Long dealby) {
        this.dealby = dealby;
    }

    public Date getDealon() {
        return dealon;
    }

    public void setDealon(Date dealon) {
        this.dealon = dealon;
    }

    public String getDealremark() {
        return dealremark;
    }

    public void setDealremark(String dealremark) {
        this.dealremark = dealremark;
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

    public Date getStatisticsdate() {
        return statisticsdate;
    }

    public void setStatisticsdate(Date statisticsdate) {
        this.statisticsdate = statisticsdate;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Long getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Long releasedate) {
        this.releasedate = releasedate;
    }

    public BigDecimal getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(BigDecimal arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public BigDecimal getTaxDeduRate() {
        return taxDeduRate;
    }

    public void setTaxDeduRate(BigDecimal taxDeduRate) {
        this.taxDeduRate = taxDeduRate;
    }

    public BigDecimal getTaxDeduMoney() {
        return taxDeduMoney;
    }

    public void setTaxDeduMoney(BigDecimal taxDeduMoney) {
        this.taxDeduMoney = taxDeduMoney;
    }

    public Long getSingleSourceId() {
        return singleSourceId;
    }

    public void setSingleSourceId(Long singleSourceId) {
        this.singleSourceId = singleSourceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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