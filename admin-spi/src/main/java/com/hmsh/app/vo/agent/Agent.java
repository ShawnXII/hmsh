package com.hmsh.app.vo.agent;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 20:54:34
 * @version 1.0.0
 */
@Table(name="agent")
public class Agent extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long dmid;

    // 代理商级别 ：1 省代理    2  市代理    3 县代理
    private Byte level;

    // 代理商名字
    private String name;

    // 身份证
    private String card;

    // 银行账号
    @Column(name="brank_account")
    private String brankAccount;

    // 银行名字
    @Column(name="brank_name")
    private String brankName;

    // 代理区域
    @Column(name="regional_agent")
    private String regionalAgent;

    // 代理时间
    @Column(name="agency_time")
    private Long agencyTime;

    // 联系电话
    @Column(name="contact_phone")
    private String contactPhone;

    // 账号
    private String account;

    // 密码
    private String pwd;

    // 状态  0 正常  1 不是代理商
    private Byte status;

    // 
    @Column(name="regional_id")
    private Long regionalId;

    // 
    private String company;

    // 0 对公   1 对私
    @Column(name="account_type")
    private Byte accountType;

    private static final long serialVersionUID = 1L;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getBrankAccount() {
        return brankAccount;
    }

    public void setBrankAccount(String brankAccount) {
        this.brankAccount = brankAccount;
    }

    public String getBrankName() {
        return brankName;
    }

    public void setBrankName(String brankName) {
        this.brankName = brankName;
    }

    public String getRegionalAgent() {
        return regionalAgent;
    }

    public void setRegionalAgent(String regionalAgent) {
        this.regionalAgent = regionalAgent;
    }

    public Long getAgencyTime() {
        return agencyTime;
    }

    public void setAgencyTime(Long agencyTime) {
        this.agencyTime = agencyTime;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getRegionalId() {
        return regionalId;
    }

    public void setRegionalId(Long regionalId) {
        this.regionalId = regionalId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
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