package com.hmsh.app.vo.user;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-05-01 21:24:44
 * @version 1.0.0
 */
@Table(name = "user_operation_log")
public class UserOperationLog extends BaseEntity<Long> {
	// 主键;
	@Id
	private Long dmid;

	// 操作人ID
	private Long operuserid;

	// 操作人名称
	private String operusername;

	// 操作内容
	private String opercontent;

	// 操作时间
	private String operresult;

	// 备注
	private String remarks;

	// 用户ID
	@NotEmpty(message = "userId不能为空!")
	private Long userid;

	// 用户类型 1 个人 2 商家
	@NotEmpty(message = "userType不能为空!")
	private Integer usertype;

	// 创建时间
	private Long crtime;

	private static final long serialVersionUID = 1L;

	public Long getDmid() {
		return dmid;
	}

	public void setDmid(Long dmid) {
		this.dmid = dmid;
	}

	public Long getOperuserid() {
		return operuserid;
	}

	public void setOperuserid(Long operuserid) {
		this.operuserid = operuserid;
	}

	public String getOperusername() {
		return operusername;
	}

	public void setOperusername(String operusername) {
		this.operusername = operusername;
	}

	public String getOpercontent() {
		return opercontent;
	}

	public void setOpercontent(String opercontent) {
		this.opercontent = opercontent;
	}

	public String getOperresult() {
		return operresult;
	}

	public void setOperresult(String operresult) {
		this.operresult = operresult;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Long getCrtime() {
		return crtime;
	}

	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}

	@Override
	public void setId(Long id) {
		this.setDmid(id);
	}

	@Override
	public Long getId() {
		return this.getDmid();
	}
}