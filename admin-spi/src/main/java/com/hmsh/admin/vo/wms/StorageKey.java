package com.hmsh.admin.vo.wms;

import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-26 09:45:06
 * @version 1.0.0
 */
@Table(name="wms_storage")
public class StorageKey extends BaseEntity<Long>  {
    // 主键; 仓储出库单dmId
    @Id
    private Long id;

    // 主键; 出库单编码
    @Id
    private Long storageno;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStorageno() {
        return storageno;
    }

    public void setStorageno(Long storageno) {
        this.storageno = storageno;
    }
}