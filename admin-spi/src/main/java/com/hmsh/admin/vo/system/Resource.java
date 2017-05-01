package com.hmsh.admin.vo.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-25 18:53:36
 * @version 1.0.0
 */
@Table(name="system_resource")
public class Resource  extends BaseEntity<Long>  {
    // 主键; 
    @Id
    private Long id;

    // 资源名称
    private String name;

    // 资源说明
    private String info;

    // 上级ID
    @Column(name="parent_id")
    private Long parentId;

    // 资源值
    @NotEmpty(message="value不能为空!")
    private String value;

    // 排序
    private Integer sequence;

    // 资源类型
    private Byte type;

    // 资源状态
    @NotEmpty(message="state不能为空!")
    private Byte state;

    // 别名(如果有值则显示该值,如果无则显示name)
    private String alias;

    // 方法名称
    private String method;

    // 请求类型 GET POST 只获取一个
    @Column(name="request_type")
    private String requestType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}