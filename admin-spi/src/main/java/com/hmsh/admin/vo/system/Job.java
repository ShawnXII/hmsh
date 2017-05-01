package com.hmsh.admin.vo.system;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-25 18:53:18
 * @version 1.0.0
 */
@Table(name="system_job")
public class Job  extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long id;

    // 职位名称
    @NotEmpty(message="name不能为空!")
    private String name;

    // 简称
    private String abbreviation;

    // 职位编号
    @NotEmpty(message="code不能为空!")
    private String code;

    // 是否启用职位权限(默认启用)
    @Column(name="dept_power")
    private Byte deptPower;

    // 状态
    private Byte state;

    // 创建时间
    @Column(name="create_time")
    @NotEmpty(message="create_time不能为空!")
    private Long createTime;

    // 职位成立时间
    @Column(name="founding_time")
    private Long foundingTime;

    // 部门
    @Column(name="dept_id")
    @NotEmpty(message="dept_id不能为空!")
    private Long deptId;

    private static final long serialVersionUID = 1L;
    
    private Dept dept;
    
    private List<String> resources; 
    
    public Job(){
    	super();
    	this.dept=new Dept();
    	this.setResources(new ArrayList<String>());
    }
    
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Byte getDeptPower() {
        return deptPower;
    }

    public void setDeptPower(Byte deptPower) {
        this.deptPower = deptPower;
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

    public Long getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(Long foundingTime) {
        this.foundingTime = foundingTime;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}
}