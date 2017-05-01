package com.hmsh.admin.vo.user;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.alibaba.fastjson.JSON;
import com.hmsh.core.base.vo.BaseEntity;
import com.hmsh.core.base.vo.Entity;

/**
 * @author wangxiang
 * @date 2017-04-28 16:32:05
 * @version 1.0.0
 */
@Table(name = "user_account_security_log")
public class AccountSecurityLog extends BaseEntity<Long> {
	// 主键;
	@Id
	private Long id;

	// 时间编号
	@Column(name = "event_code")
	@NotEmpty(message = "event_code不能为空!")
	private String eventCode;

	// 事件描述
	@Column(name = "event_describe")
	private String eventDescribe;

	// 改之前的数据 json记录 用于回滚
	@Column(name = "event_data")
	private String eventData;

	// IP地址
	private String ip;

	// 用户名称
	private String username;

	// 发生时间
	@Column(name = "create_time")
	@NotEmpty(message = "create_time不能为空!")
	private Long createTime;

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param eventCode
	 */
	public AccountSecurityLog(EventCode eventCode) {
		super();
		this.eventCode = eventCode.name();
		this.eventDescribe = eventCode.getDescribe();
		this.createTime = System.currentTimeMillis();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventDescribe() {
		return eventDescribe;
	}

	public void setEventDescribe(String eventDescribe) {
		this.eventDescribe = eventDescribe;
	}

	public String getEventData() {
		return eventData;
	}

	public void setEventData(String eventData) {
		this.eventData = eventData;
	}

	public <T extends Entity<PK>, PK extends java.io.Serializable> void setEventData(T bean) {
		try {
			this.eventData = JSON.toJSONString(bean);
		} catch (Exception e) {
			
		}
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
}