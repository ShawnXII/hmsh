package com.hmsh.admin.service.system;

import javax.annotation.Resource;

import com.hmsh.admin.dao.system.MenuDao;
import com.hmsh.admin.service.facade.system.MenuFacadeService;
import com.hmsh.admin.vo.system.Menu;
import com.hmsh.core.base.BaseDao;

public class MenuService  implements MenuFacadeService {

	@Resource
	private MenuDao menuDao;

	

}
