package com.hmsh.admin.vo.system;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-25 18:53:04
 * @version 1.0.0
 */
@Table(name="system_dictionaries")
public class Dictionaries  extends BaseEntity<Long>  {
    // 主键; 
    @Id
    private Long id;

    // 标签名
    private String label;

    // 值
    @NotEmpty(message="value不能为空!")
    private String value;

    // 类型
    @NotEmpty(message="type不能为空!")
    private String type;

    // 说明
    private String info;

    // 排序
    private Integer sequence;

    // 状态 0:正常 1:禁用
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}