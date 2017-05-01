package com.hmsh.admin.vo.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-25 18:52:28
 * @version 1.0.0
 */
@Table(name="system_company")
public class Company  extends BaseEntity<Long>  {
    // 主键; 
    @Id
    private Long id;

    // 公司名称
    @NotEmpty(message="name不能为空!")
    private String name;

    // 公司简称
    private String abbreviation;

    // 公司Logo
    private String logo;

    // 成立时间
    @Column(name="founding_time")
    @NotEmpty(message="founding_time不能为空!")
    private String foundingTime;

    // 注册地址
    @Column(name="entroll_address")
    private String entrollAddress;

    // 状态
    @NotEmpty(message="state不能为空!")
    private Byte state;

    // 录入时间
    @Column(name="create_time")
    @NotEmpty(message="create_time不能为空!")
    private Long createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(String foundingTime) {
        this.foundingTime = foundingTime;
    }

    public String getEntrollAddress() {
        return entrollAddress;
    }

    public void setEntrollAddress(String entrollAddress) {
        this.entrollAddress = entrollAddress;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}