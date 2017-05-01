package com.hmsh.admin.vo.wms;

import javax.persistence.Id;
import javax.persistence.Table;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-26 09:44:09
 * @version 1.0.0
 */
@Table(name="wms_goods_photo")
public class GoodsPhoto extends BaseEntity<Long>{
    // 主键; 
    @Id
    private Long id;

    // skuID
    private Long skuid;

    // 图片路径
    private String path;

    // 类型
    private Long type;

    // 排序
    private Long sequence;

    // 图片说明
    private String context;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuid() {
        return skuid;
    }

    public void setSkuid(Long skuid) {
        this.skuid = skuid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}