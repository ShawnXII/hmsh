package com.hmsh.app.vo.wms;

import java.util.ArrayList;
import java.util.List;

import com.hmsh.core.base.vo.BaseEntity;
/**
 * 商品发货单
 * @author leichao
 *
 */
public class Storage extends BaseEntity<Long>{
	private static final long serialVersionUID = -4608770932203060759L;
	private Long id;
	/**
	 * 单据编号
	 */
	private Long storageNo;
	/**
	 * 供应商编码
	 */
	private Long supplierNo;
	/**
	 * 供应商名称
	 */
	private String supplierName;
	/**
	 * 客户编号
	 */
	private Long customerNo;
    /**
     * 客户名称
     */
	private String customerName;
	/**
	 * 单据日期
	 */
	private Long storageDate;
	/**
	 * 发货日期
	 */
	private Long deliveryDate;
	/**
	 * 出库单状态
	 */
	private int status;
	/**
	 * 备注
	 */
	private String remarks;
	
	private List<StorageInfo> storageInfos=new ArrayList<>(); 
	
	public List<StorageInfo> getStorageInfos() {
		return storageInfos;
	}
	public void setStorageInfos(List<StorageInfo> storageInfos) {
		this.storageInfos = storageInfos;
	}
	public Long getStorageNo() {
		return storageNo;
	}
	public void setStorageNo(Long storageNo) {
		this.storageNo = storageNo;
	}
	public Long getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(Long supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(Long customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getStorageDate() {
		return storageDate;
	}
	public void setStorageDate(Long storageDate) {
		this.storageDate = storageDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Long deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StorageIno [storageNo=" + storageNo + ", supplierNo=" + supplierNo + ", supplierName=" + supplierName
				+ ", customerNo=" + customerNo + ", customerName=" + customerName + ", storageDate=" + storageDate
				+ ", deliveryDate=" + deliveryDate + ", status=" + status + ", remarks=" + remarks
				+ "]";
	}
}
