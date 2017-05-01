package com.hmsh.admin.service.system;

import javax.annotation.Resource;

import com.hmsh.admin.dao.system.RoleDao;
import com.hmsh.admin.service.facade.system.RoleFacadeService;
import com.hmsh.admin.vo.system.Role;
import com.hmsh.core.base.BaseDao;

public class RoleService  implements RoleFacadeService {

	@Resource
	private RoleDao roleDao;



}
