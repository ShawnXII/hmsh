package com.hmsh.admin.vo.system;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-25 18:52:41
 * @version 1.0.0
 */
@Table(name="system_config")
public class Config  extends BaseEntity<Long>  {
    // 主键; 
    @Id
    private Long id;

    // 设置Key
    @NotEmpty(message="key不能为空!")
    private String key;

    // 设置值
    @NotEmpty(message="value不能为空!")
    private String value;

    // 设置说明
    private String info;

    // 状态
    @NotEmpty(message="state不能为空!")
    private Byte state;

    // 设置类型
    @NotEmpty(message="type不能为空!")
    private Byte type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}