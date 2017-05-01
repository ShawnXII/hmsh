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
 * @date 2017-04-25 18:52:55
 * @version 1.0.0
 */
@Table(name = "system_dept")
public class Dept extends BaseEntity<Long> {
	// 主键;
	@Id
	private Long id;

	// 部门名称
	@NotEmpty(message = "name不能为空!")
	private String name;

	// 部门简称
	private String abbreviation;

	// 部门编号
	private String code;

	// 状态
	private Integer state;

	// 创建时间
	@Column(name = "create_time")
	@NotEmpty(message = "create_time不能为空!")
	private Long createTime;

	// 部门成立时间
	@Column(name = "founding_time")
	private Long foundingTime;

	private static final long serialVersionUID = 1L;

	private List<String> resources;

	public Dept() {
		super();
		this.resources = new ArrayList<>();
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
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

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}
}