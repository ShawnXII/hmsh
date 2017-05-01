package com.hmsh.app.vo.system;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

@Document(collection ="category")
public class Category  extends BaseEntity<Long>{

	private static final long serialVersionUID = 9181238344070257413L;
	/** 标签名字 */
	private String name;
	/** 标签分类  2 商家行业分类  1 个人职业分类 */
	
	private Integer type;
	/** 添加时间 */
	private Long crtime;
	/** 状态  0 正常 1 屏蔽 */
	private Integer status;
	/**排序*/
	private Integer order;
	/**
	 * 扣点比例
	 */
	private Double scale;
	/**
	 * 返现比例
	 */
	private Double back;
	/**
	 * 金币赠送比例
	 */
	private Double goldGift;
	/**
	 * 最高赠送比例
	 */
	private Double highestGift;
	/**
	 * 最高返现
	 */
	private Double highestBack;
	/**
	 * 栏目图片
	 */
	private String sysHeadImg;
	/**
	 * 自己集合
	 */
	private List<Category> categoryList;
	
	private Long dmId;
	
	private Long parentID;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getCrtime() {
		return crtime;
	}
	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Double getScale() {
		return scale;
	}
	public void setScale(Double scale) {
		this.scale = scale;
	}
	public Double getBack() {
		return back;
	}
	public void setBack(Double back) {
		this.back = back;
	}
	public Double getGoldGift() {
		return goldGift;
	}
	public void setGoldGift(Double goldGift) {
		this.goldGift = goldGift;
	}
	public Double getHighestGift() {
		return highestGift;
	}
	public void setHighestGift(Double highestGift) {
		this.highestGift = highestGift;
	}
	public Double getHighestBack() {
		return highestBack;
	}
	public void setHighestBack(Double highestBack) {
		this.highestBack = highestBack;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public Long getParentID() {
		return parentID;
	}
	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}
	public String getSysHeadImg() {
		return sysHeadImg;
	}
	public void setSysHeadImg(String sysHeadImg) {
		this.sysHeadImg = sysHeadImg;
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
	
}
