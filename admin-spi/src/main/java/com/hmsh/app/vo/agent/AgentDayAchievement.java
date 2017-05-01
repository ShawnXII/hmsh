package com.hmsh.app.vo.agent;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 20:53:27
 * @version 1.0.0
 */
@Table(name="agent_day_achievement")
public class AgentDayAchievement extends BaseEntity<Long>{
    // 主键; 
    @Id
    private Long dmid;

    // tradingDate
    @NotEmpty(message="tradingDate不能为空!")
    private Long tradingdate;

    // 代理商id
    @NotEmpty(message="agentId不能为空!")
    private Long agentid;

    // 区域文本
    @NotEmpty(message="region不能为空!")
    private String region;

    // 省
    @NotEmpty(message="provinceId不能为空!")
    private Long provinceid;

    // 市
    @NotEmpty(message="cityId不能为空!")
    private Long cityid;

    // 区
    @NotEmpty(message="countyId不能为空!")
    private Long countyid;

    // 联系人
    private String contactname;

    // 联系人电话
    private String contactphone;

    // 日均目标金额
    private BigDecimal daytargetamount;

    // 交易金额
    @NotEmpty(message="tradeAmount不能为空!")
    private BigDecimal tradeamount;

    // 差额
    @NotEmpty(message="tradeBalnceAmount不能为空!")
    private BigDecimal tradebalnceamount;

    // 是否满足60%的日均目标    0 未完成 1完成
    @NotEmpty(message="achieveFlag不能为空!")
    private Byte achieveflag;

    // 创建人
    @NotEmpty(message="createBy不能为空!")
    private Long createby;

    // 
    @NotEmpty(message="createTime不能为空!")
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

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Long provinceid) {
        this.provinceid = provinceid;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public Long getCountyid() {
        return countyid;
    }

    public void setCountyid(Long countyid) {
        this.countyid = countyid;
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