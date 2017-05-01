package com.hmsh.admin.vo.wms;

import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author wangxiang 
 * @date 2017-04-26 09:45:06
 * @version 1.0.0
 */
@Table(name="wms_storage")
public class Storage extends StorageKey  {
    // 供应链编码
    @NotEmpty(message="supplierNo不能为空!")
    private Long supplierno;

    // 供应链名称
    private String suppliername;

    // 客户编码
    @NotEmpty(message="customerNo不能为空!")
    private Long customerno;

    // 客户名称
    private String customername;

    // 单据日期
    @NotEmpty(message="storageDate不能为空!")
    private Long storagedate;

    // 出库时间
    @NotEmpty(message="deliveryDate不能为空!")
    private Long deliverydate;

    // 状态
    @NotEmpty(message="status不能为空!")
    private Long status;

    // 备注
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Long getSupplierno() {
        return supplierno;
    }

    public void setSupplierno(Long supplierno) {
        this.supplierno = supplierno;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public Long getCustomerno() {
        return customerno;
    }

    public void setCustomerno(Long customerno) {
        this.customerno = customerno;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Long getStoragedate() {
        return storagedate;
    }

    public void setStoragedate(Long storagedate) {
        this.storagedate = storagedate;
    }

    public Long getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Long deliverydate) {
        this.deliverydate = deliverydate;
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