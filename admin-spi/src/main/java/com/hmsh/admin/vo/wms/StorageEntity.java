package com.hmsh.admin.vo.wms;

/**
 * @ClassName StorageEntity
 * @Description 出库单
 * @author ShawnXII
 * @date 2017-04-22 16:08:41
 * @version 1.0 
 */
public class StorageEntity extends StorageKey {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8659205846595604302L;
	//供应链编码
    private Long supplierNo;
    //供应链名称
    private String supplierName;
    //客户编码
    private Long customerNo;
    //客户名称
    private String customerName;
    //单据日期
    private Long storageDate;
    //出库时间
    private Long deliveryDate;
    //状态
    private Long status;
    //备注
    private String remarks;

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
    public Long getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public Long getStatus() {
        return status;
    }
    public void setStatus(Long status) {
        this.status = status;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}