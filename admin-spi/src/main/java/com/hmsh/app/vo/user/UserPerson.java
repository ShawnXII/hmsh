package com.hmsh.app.vo.user;

import java.util.InputMismatchException;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 个人认证
 * 
 * @author ShawnXII
 *
 */
@Document(collection = "user_person")
public class UserPerson extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 801065445216001856L;
	
	private Long dmId;
	/* 申请人id */
	private Long userId;
	/* 申请人名字 */
	private String name;
	/* 身份证号 */
	private String pno;
	/* 执照照片 */
	private String pnoImg;
	/* 申请时间 */
	private Long applyTime;
	/* 0 未审核 1 通过 2 不通过 */
	private Integer applyStatus;
	/* 1 有新的审核 */
	private Integer newApply;
	/* 有效期 */
	private Long newApplyTime;
	/* 审核时间 */
	private java.lang.Long applyReviewTime;
	/* 审核人 */
	private java.lang.Long applyReviewUid;
	/* 状态 0 正常 1 失效 */
	private Integer status;

	private String applyReviewContont; // 审核不通过描述

	// 用户信息
	@DBRef(db="user")
	private User user;

	/* =====================查询====================== */
	private String keyword;// 姓名/身份证/注册手机号

	// 开始时间
	private Long startTime;
	// 结束时间
	private Long endTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPnoImg() {
		return pnoImg;
	}

	public void setPnoImg(String pnoImg) {
		this.pnoImg = pnoImg;
	}

	public Long getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Long applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getNewApply() {
		return newApply;
	}

	public void setNewApply(Integer newApply) {
		this.newApply = newApply;
	}

	public Long getNewApplyTime() {
		return newApplyTime;
	}

	public void setNewApplyTime(Long newApplyTime) {
		this.newApplyTime = newApplyTime;
	}

	public java.lang.Long getApplyReviewTime() {
		return applyReviewTime;
	}

	public void setApplyReviewTime(java.lang.Long applyReviewTime) {
		this.applyReviewTime = applyReviewTime;
	}

	public java.lang.Long getApplyReviewUid() {
		return applyReviewUid;
	}

	public void setApplyReviewUid(java.lang.Long applyReviewUid) {
		this.applyReviewUid = applyReviewUid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getApplyReviewContont() {
		return applyReviewContont;
	}

	public void setApplyReviewContont(String applyReviewContont) {
		this.applyReviewContont = applyReviewContont;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPerson [userId=" + userId + ", name=" + name + ", pno=" + pno + ", pnoImg=" + pnoImg
				+ ", applyTime=" + applyTime + ", applyStatus=" + applyStatus + ", newApply=" + newApply
				+ ", newApplyTime=" + newApplyTime + ", applyReviewTime=" + applyReviewTime + ", applyReviewUid="
				+ applyReviewUid + ", status=" + status + ", applyReviewContont=" + applyReviewContont + ", user="
				+ user + "]";
	}

	@Override
	public void setId(Long id) throws InputMismatchException {
		this.dmId = id;
	}

	@Override
	public Long getId() {
		return this.dmId;
	}

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
