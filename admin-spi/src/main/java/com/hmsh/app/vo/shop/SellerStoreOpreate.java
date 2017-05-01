package com.hmsh.app.vo.shop;

import java.util.InputMismatchException;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:SellerStoreOpreate
 * <br>Description:(店铺操作日志VO实体类)
 * <br>Copyright: Copyright © 2017
 * <br>Company: 深圳市阿凡达互联网技术开发有限公司
 * @author Tom Tang
 * @version v1.0 2017-01-04
 */
public class SellerStoreOpreate extends BaseEntity<Long> {
	
	private static final long serialVersionUID = -4781243533644738293L;
	private Long dmId;
    /**
     *  注还有可能是员工表的id(仅表示被操作记录表Id)
     */
    private Long sellerId;
    
    /**
     * 年费订单Id
     */
    private Long annualId;
    /**
     * 操作时间
     */
    private Long operateTime;
    /**
     * 操作内容
     */
    private String operateContent;
    /**
     * 操作变更
     */
    private String operateChange;
    /**
     * 操作备注
     */
    private String operateRemark;
    /**
     * 操作人
     */
    private String operater;
    public SellerStoreOpreate(){
		super();
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

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getAnnualId() {
		return annualId;
	}

	public void setAnnualId(Long annualId) {
		this.annualId = annualId;
	}

	public Long getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateContent() {
		return operateContent;
	}

	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}

	public String getOperateChange() {
		return operateChange;
	}

	public void setOperateChange(String operateChange) {
		this.operateChange = operateChange;
	}

	public String getOperateRemark() {
		return operateRemark;
	}

	public void setOperateRemark(String operateRemark) {
		this.operateRemark = operateRemark;
	}

	public String getOperater() {
		return operater;
	}

	public void setOperater(String operater) {
		this.operater = operater;
	}
	
}
