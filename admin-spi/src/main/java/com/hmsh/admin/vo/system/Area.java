package com.hmsh.admin.vo.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-04-25 18:52:20
 * @version 1.0.0
 */
@Table(name="system_area")
public class Area  extends BaseEntity<Long>  {
    // 主键; 
    @Id
    private Long id;

    // 地址编号
    private String code;

    // 等级(国0 区1 省2 市3 县4 镇5 乡6)
    @NotEmpty(message="level不能为空!")
    private Byte level;

    // 名称
    @NotEmpty(message="name不能为空!")
    private String name;

    // 等级称号(国 区 省 市 县 镇 乡)
    @Column(name="rank_title")
    private String rankTitle;

    // 上级ID
    @Column(name="parent_id")
    private Long parentId;

    // 排序
    private Integer sequence;

    // 状态()
    @NotEmpty(message="state不能为空!")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRankTitle() {
        return rankTitle;
    }

    public void setRankTitle(String rankTitle) {
        this.rankTitle = rankTitle;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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