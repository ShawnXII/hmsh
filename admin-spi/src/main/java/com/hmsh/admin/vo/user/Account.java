package com.hmsh.admin.vo.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.UserDetails;

import com.hmsh.admin.vo.system.Role;
import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-04-28 15:47:22
 * @version 1.0.0
 */
@Table(name = "user_account")
public class Account extends BaseEntity<Long> implements UserDetails{
	// 主键;
	@Id
	private Long id;

	// 用户名
	@NotEmpty(message = "username不能为空!")
	private String username;

	// 登录密码
	private String password;

	// 盐值(加密key 创建帐号时创建)
	@NotEmpty(message = "salt不能为空!")
	private String salt;

	// 邮箱
	private String email;

	// 手机号码
	private String mobile;

	// 帐号状态(0:正常 1:限制登录[帐号安全表里面操作] 2:删除)
	private Integer state;

	// 帐号类型 (0:普通帐号 1:管理员[拥有管理员权限] 2:测试帐号 [测试权限])
	private Integer type;

	// 创建时间
	@Column(name = "create_time")
	private Long createTime;

	// 最后一次登录地址
	private String ip;

	// 是否需要修改密码 
	@Column(name = "is_modify_password")
	private Integer isModifyPassword;

	//
	@Column(name = "last_login_time")
	private Long lastLoginTime;

	private static final long serialVersionUID = 1L;
	
	@Transient
	private UserInfo userInfo;
	
	@Transient
	private List<Role> authorities;
	
	public void setDefault(){
		if(this.getType()==null){
			this.setType(0);
		}
		if(this.getState()==null){
			this.setState(0);
		}
		if(this.getCreateTime()==null){
			this.setCreateTime(System.currentTimeMillis());
		}
		if(this.getAuthorities()==null){
			this.setAuthorities(new ArrayList<Role>());
		}		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsModifyPassword() {
		return isModifyPassword;
	}

	public void setIsModifyPassword(Integer isModifyPassword) {
		this.isModifyPassword = isModifyPassword;
	}

	@Override
	public List<Role> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}
}