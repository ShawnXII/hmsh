package com.hmsh.admin.vo.user;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.admin.vo.system.Job;
import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-04-25 18:54:07
 * @version 1.0.0
 */
@Table(name = "user_info")
public class UserInfo extends BaseEntity<Long> {
	// 主键;
	@Id
	private Long id;

	// 姓
	private String surname;

	// 名称
	private String name;

	// 英文名称
	@Column(name = "en_name")
	private String enName;

	// 昵称
	private String nickname;

	// 身份证
	@Column(name = "card_no")
	private String cardNo;

	// 邮箱地址
	private String email;

	// 电话号码
	private String mobile;

	// 手机号码
	private String phone;

	// 个性签名
	private String autograph;

	// 备注
	private String remarks;

	// 生日
	private String birthday;

	// 归属地(户籍)
	private String address;

	// 性别 0:女 1:男 2:保密
	private Byte sex;

	// 帐号ID
	@Column(name = "account_id")
	@NotEmpty(message = "account_id不能为空!")
	private Long accountId;

	// 职位ID
	@Column(name = "job_id")
	private Long jobId;

	private static final long serialVersionUID = 1L;
	
	@Transient
	private Job job;

	public UserInfo() {
		super();
		job = new Job();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAutograph() {
		return autograph;
	}

	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}