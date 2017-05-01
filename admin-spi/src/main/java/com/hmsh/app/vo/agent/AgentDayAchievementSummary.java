package com.hmsh.app.vo.agent;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 20:54:19
 * @version 1.0.0
 */
@Table(name="agent_day_achievement_summary")
public class AgentDayAchievementSummary extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long dmid;

    // 交易日期
    private Long tradingdate;

    // 联系人
    private String contactname;

    // 联系人电话
    private String contactphone;

    // 日均目标金额
    private BigDecimal daytargetamount;

    // 交易金额
    private BigDecimal tradeamount;

    // 差额
    private BigDecimal tradebalnceamount;

    // 是否满足60%的日均目标    0 未完成 1完成
    private Byte achieveflag;

    // 
    private Long createby;

    // 
    private Long createtime;

    // 
    private Long updateon;

    // 
    private Long updateby;

    private static final long serialVersionUID = 1L;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public Long getTradingdate() {
        return tradingdate;
    }

    public void setTradingdate(Long tradingdate) {
        this.tradingdate = tradingdate;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public BigDecimal getDaytargetamount() {
        return daytargetamount;
    }

    public void setDaytargetamount(BigDecimal daytargetamount) {
        this.daytargetamount = daytargetamount;
    }

    public BigDecimal getTradeamount() {
        return tradeamount;
    }

    public void setTradeamount(BigDecimal tradeamount) {
        this.tradeamount = tradeamount;
    }

    public BigDecimal getTradebalnceamount() {
        return tradebalnceamount;
    }

    public void setTradebalnceamount(BigDecimal tradebalnceamount) {
        this.tradebalnceamount = tradebalnceamount;
    }

    public Byte getAchieveflag() {
        return achieveflag;
    }

    public void setAchieveflag(Byte achieveflag) {
        this.achieveflag = achieveflag;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdateon() {
        return updateon;
    }

    public void setUpdateon(Long updateon) {
        this.updateon = updateon;
    }

    public Long getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Long updateby) {
        this.updateby = updateby;
    }
    
    @Override
	public void setId(Long id) {
		this.dmid=id;
	}

	@Override
	public Long getId() {
		return this.getDmid();
	}
}