package com.hmsh.admin.vo.system;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang
 * @date 2017-04-25 18:51:53
 * @version 1.0.0
 */
@Table(name = "system_accessory")
public class Accessory extends BaseEntity<Long> {
	// 主键;
	@Id
	private Long id;

	// 图片名称
	private String name;

	// 图片路径
	@NotEmpty(message = "path不能为空!")
	private String path;

	// 附件大小(KB)
	private BigDecimal size;

	// 图片宽度
	private BigDecimal width;

	// 图片高度
	private BigDecimal height;

	// 附件扩展名
	private String ext;

	// 图片说明
	private String info;

	// 上传用户
	private String username;

	// 上传IP地址
	private String ip;

	// 上传时间
	@Column(name = "create_time")
	@NotEmpty(message = "create_time不能为空!")
	private Long createTime;

	// hashCode值 用于图片对比
	@Column(name = "hash_code")
	private String hashCode;

	private static final long serialVersionUID = 1L;
	
	public Accessory(){
		super();
		this.createTime=System.currentTimeMillis();
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	@Override
	public String toString() {
		return "Accessory [id=" + id + ", name=" + name + ", path=" + path + ", size=" + size + ", width=" + width
				+ ", height=" + height + ", ext=" + ext + ", info=" + info + ", username=" + username + ", ip=" + ip
				+ ", createTime=" + createTime + ", hashCode=" + hashCode + "]";
	}
	
}