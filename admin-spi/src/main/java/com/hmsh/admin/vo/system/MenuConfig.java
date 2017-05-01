package com.hmsh.admin.vo.system;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:38:59
 * @version 1.0.0
 */
@Table(name="system_menu_config")
public class MenuConfig implements Serializable {
    // 菜单ID
    @Column(name="menu_id")
    @NotEmpty(message="menu_id不能为空!")
    private Long menuId;

    // 设置类型
    @NotEmpty(message="type不能为空!")
    private String type;

    // 设置key
    @NotEmpty(message="label不能为空!")
    private String label;

    // 设置值(可以是json格式表达)
    @NotEmpty(message="value不能为空!")
    private String value;

    // 
    private Long id;

    private static final long serialVersionUID = 1L;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}