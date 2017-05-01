package com.hmsh.admin.web.controller.system;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hmsh.admin.core.exception.ServiceException;
import com.hmsh.admin.core.util.Commutil;
import com.hmsh.admin.core.util.DataTablePage;
import com.hmsh.admin.core.util.DataTableUtil;
import com.hmsh.admin.foundation.domain.system.vo.Role;
import com.hmsh.admin.foundation.facade.system.RoleFacadeService;
import com.hmsh.admin.web.controller.BaseController;

/**
 * 角色 管理
 * 
 * @author ShawnXII
 */
@Controller
@RequestMapping("/system/role")
public class RoleViewController extends BaseController {

	@Autowired
	private RoleFacadeService roleService;


	/**
	 * 角色主页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/index.htm"},method={RequestMethod.GET})
	public String indexView(HttpServletRequest request, Model model){
		return "system/role/index";
	}
	/**
	 * 分页查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/query"},method={RequestMethod.GET})
	public @ResponseBody  DataTablePage<Role,Long> query(HttpServletRequest request){
		Enumeration<String> names=request.getAttributeNames();
		while(names.hasMoreElements()){
			String str=names.nextElement();
			System.out.println("key:"+str+";value:"+request.getParameter(str));
			
		}
		Integer pageIndex = Commutil.null2Int(request.getParameter("pageIndex"), 1);
		Integer pageSize = Commutil.null2Int(request.getParameter("pageSize"), 20);
		String orderBy = Commutil.null2String(request.getParameter("orderBy"));
		try {
			Page<Role> page = roleService.query(pageIndex, pageSize);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	/**
	 * 检查
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> check(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		map.put("flag", false);
		map.put("code", "000");
		map.put("errorMsg", "值不存在!");
		String code = Commutil.null2String(request.getParameter("code"));
		String name = Commutil.null2String(request.getParameter("name"));
		if (StringUtils.isBlank(code) && StringUtils.isBlank(name)) {
			map.put("flag", false);
			map.put("code", "002");
			map.put("errorMsg", "检查值不能为空!");
		}
		boolean flag = false;
		try {
			Role role = new Role();
			if (StringUtils.isNotBlank(code)) {
				role.setRoleCode(code);
			} else {
				role.setRoleName(name);
			}
			Long count = this.roleService.queryCount(role);
			flag = count > 0;
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		if (!flag) {
			map.put("flag", true);
			map.put("code", "000");
			map.put("errorMsg", "");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> modify(HttpServletRequest request) {
		Map<String, Object> result=new HashMap<>();
		result.put("flag", true);
		Long id = Commutil.null2Long(request.getParameter("id"), -1);
		String key = Commutil.null2String(request.getParameter("key"));
		String value = Commutil.null2String(request.getParameter("value"));
		try {
			if (id == null || id < 1) {
				throw new Exception("ID 不能为空");
			}
			Role role=new Role();
			role.setId(id);
			if("info".equals(key)){
				role.setInfo(value);
			}else{
				role.setRoleName(value);
			}
			this.roleService.modifyNotNull(role);
			result.put("message", "修改成功!");
		} catch (Exception e) {
			result.put("flag", false);
			result.put("errorMsg", e.getMessage());
		}
		return result;
	}

}
