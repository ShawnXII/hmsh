package com.hmsh.admin.vo.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-25 18:52:12
 * @version 1.0.0
 */
@Table(name="system_album")
public class Album  extends BaseEntity<Long>  {
    // 主键; 
    @Id
    private Long id;

    // 相册类型(0:普通相册  1:系统相册)
    @NotEmpty(message="type不能为空!")
    private Byte type;

    // 相册名称
    @NotEmpty(message="title不能为空!")
    private String title;

    // 相册归属用户
    private String username;

    // 说明(备注)
    private String info;

    // 创建时间
    @Column(name="create_time")
    @NotEmpty(message="create_time不能为空!")
    private Long createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}