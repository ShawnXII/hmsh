package com.hmsh.admin.vo.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:38:31
 * @version 1.0.0
 */
@Table(name="system_company_config")
public class CompanyConfig extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long id;

    // 设置KEY
    @NotEmpty(message="key不能为空!")
    private String key;

    // 设置Value
    @NotEmpty(message="value不能为空!")
    private String value;

    // 公司ID
    @Column(name="company_id")
    private Long companyId;

    // 设置说明
    private String info;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}