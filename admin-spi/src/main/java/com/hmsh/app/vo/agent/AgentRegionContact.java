package com.hmsh.app.vo.agent;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 20:54:51
 * @version 1.0.0
 */
@Table(name="agent_region_contact")
public class AgentRegionContact extends BaseEntity<Long> {
    // 主键; 代理商
    @Id
    private Long dmid;

    // 
    @NotEmpty(message="agentId不能为空!")
    private Long agentid;

    // 代理区域文本
    @NotEmpty(message="region不能为空!")
    private String region;

    // 联系电话
    @NotEmpty(message="contactPhone不能为空!")
    private String contactphone;

    // 联系人
    @NotEmpty(message="contactName不能为空!")
    private String contactname;

    // 
    @NotEmpty(message="createBy不能为空!")
    private Long createby;

    // 
    @NotEmpty(message="createTime不能为空!")
    private Long createtime;

    // 
    private Long updateby;

    // 
    private Long updateon;

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

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
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

    public Long getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Long updateby) {
        this.updateby = updateby;
    }

    public Long getUpdateon() {
        return updateon;
    }

    public void setUpdateon(Long updateon) {
        this.updateon = updateon;
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