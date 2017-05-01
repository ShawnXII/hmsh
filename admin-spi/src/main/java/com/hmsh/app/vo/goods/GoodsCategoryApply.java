package com.hmsh.app.vo.goods;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 
 * <p>
 * Title:GoodsClassify
 * </p>
 * <p>
 * Description:(商家申请添加分类)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 优爵正品（深圳）网络科技有限公司
 * </p>
 * 
 * @author: Tom Tong
 * @version v1.0 2016年10月20日
 */
@Document(collection = "goods_classify_apply")
public class GoodsCategoryApply extends BaseEntity<Long> {

	private static final long serialVersionUID = -9085162587845644182L;

	@Indexed
	private Long dmId;
	// 一级分类名称
	@Field(value = "one_category_name")
	private String oneCategoryName;
	// 二级分类名称
	@Field(value = "two_category_name")
	private String twoCategoryName;
	// 商品名称
	@Field(value = "goods_name")
	private String goodsName;
	// 申请人联系电话
	@Field(value = "telephone")
	private String telephone;
	// 申请理由
	@Field(value = "apply_reason")
	private String applyReason;
	// 申请时间
	@Field(value = "apply_time")
	private Long applyTime;
	// 申请人
	@Field(value = "apply_id")
	private String applyId;
	// 审核时间
	@Field(value = "audit_time")
	private Long auditTime;
	// 审核人
	@Field(value = "audit_id")
	private String auditId;
	// 处理状态 1：未处理；2：审核通过；3：审核未通过
	@Field(value = "status")
	private Integer status;

	public String getOneCategoryName() {
		return oneCategoryName;
	}

	public void setOneCategoryName(String oneCategoryName) {
		this.oneCategoryName = oneCategoryName;
	}

	public String getTwoCategoryName() {
		return twoCategoryName;
	}

	public void setTwoCategoryName(String twoCategoryName) {
		this.twoCategoryName = twoCategoryName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public Long getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Long applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public Long getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Long auditTime) {
		this.auditTime = auditTime;
	}

	public String getAuditId() {
		return auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public void setId(Long id) {
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

}
