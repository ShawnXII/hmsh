package com.hmsh.app.vo.agent;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 20:55:07
 * @version 1.0.0
 */
@Table(name="agent_week_achievement")
public class AgentWeekAchievement extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long dmid;

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

    // 7天目标基数
    private BigDecimal weektargetamount;

    // 交易金额
    @NotEmpty(message="tradeAmount不能为空!")
    private BigDecimal tradeamount;

    // 差额
    @NotEmpty(message="tradeBalnceAmount不能为空!")
    private BigDecimal tradebalnceamount;

    // 是否满足目标基数 0未达标 1达标
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

    // 
    @NotEmpty(message="fromDay不能为空!")
    private Long fromday;

    // 
    @NotEmpty(message="toDay不能为空!")
    private Long today;

    private static final long serialVersionUID = 1L;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
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

    public BigDecimal getWeektargetamount() {
        return weektargetamount;
    }

    public void setWeektargetamount(BigDecimal weektargetamount) {
        this.weektargetamount = weektargetamount;
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

    public Long getFromday() {
        return fromday;
    }

    public void setFromday(Long fromday) {
        this.fromday = fromday;
    }

    public Long getToday() {
        return today;
    }

    public void setToday(Long today) {
        this.today = today;
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