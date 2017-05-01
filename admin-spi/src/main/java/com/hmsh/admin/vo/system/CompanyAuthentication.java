package com.hmsh.admin.vo.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:38:12
 * @version 1.0.0
 */
@Table(name="system_company_authentication")
public class CompanyAuthentication extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long id;

    // 附件路径
    private String enclosure;

    // 认证说明
    private String explain;

    // 状态
    @NotEmpty(message="state不能为空!")
    private Byte state;

    // 认证说明
    private String info;

    // 认证名称
    private String title;

    // 认证(通过)时间
    @Column(name="transit_time")
    private Long transitTime;

    // 认证申请时间
    @Column(name="create_time")
    @NotEmpty(message="create_time不能为空!")
    private Long createTime;

    // 公司ID
    @Column(name="company_id")
    @NotEmpty(message="company_id不能为空!")
    private Long companyId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(Long transitTime) {
        this.transitTime = transitTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}