package com.hmsh.admin.vo.system;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:39:16
 * @version 1.0.0
 */
@Table(name="system_role")
public class Role extends BaseEntity<Long> implements GrantedAuthority {
    // 主键; 
    @Id
    private Long id;

    // 角色编码
    @Column(name="role_code")
    @NotEmpty(message="role_code不能为空!")
    private String roleCode;

    // 角色名称
    @Column(name="role_name")
    @NotEmpty(message="role_name不能为空!")
    private String roleName;

    // 角色类型(0:普通角色 1:系统角色)
    @NotEmpty(message="type不能为空!")
    private Byte type;

    // 角色信息
    private String info;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

	@Override
	public String getAuthority() {
		return this.roleCode;
	}
}