package com.hmsh.admin.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hmsh.admin.core.exception.ServiceException;
import com.hmsh.admin.core.util.Commutil;
import com.hmsh.admin.core.util.DataTablePage;
import com.hmsh.admin.core.util.DataTableUtil;
import com.hmsh.admin.foundation.domain.system.vo.Dictionaries;
import com.hmsh.admin.foundation.facade.system.DictionariesFacadeService;
import com.hmsh.admin.foundation.facade.system.MenuFacadeService;

/**
 * 系统管理
 * 功能点:
 * 	日志管理
 *  角色/权限/资源管理
 *  菜单管理
 *  帐号管理
 *  部门职位管理
 *  系统字典设置 
 *  系统设置
 *  文件管理  
 *  Controller 按照功能菜单进行创建,以便于统一的管理 
 *  可以设置加载css样式(可以扩展)
 *  可以设置加载js(可以扩展)
 *  多样化加载页面(系统生成/自己编写:有(ifarme/div[默认])2种模式)
 *  Table可视化编辑
 * @author ShawnXII
 */
@Controller
@RequestMapping("/system")
public class SystemManagementController extends BaseController{
	
	//系统字典
	@Autowired
	private DictionariesFacadeService dictionariesService;
	
	//系统菜单管理
	@Autowired
	private MenuFacadeService menuFacadeService;
	/**
	 * 系统字典管理
	 * @return
	 */
	@RequestMapping(value = { "/dictionaries.htm" }, method = RequestMethod.GET)
	public String dictionariesView(HttpServletRequest request){
		return "system/dictionaries";
	}
	
	/**
	 * 分页查询字典数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"/dictionaries/query"},method={RequestMethod.GET})
	public @ResponseBody  DataTablePage<Dictionaries,Long> query(HttpServletRequest request){
		Integer pageIndex = Commutil.null2Int(request.getParameter("pageIndex"), 1);
		Integer pageSize = Commutil.null2Int(request.getParameter("pageSize"), 20);
		String orderBy = Commutil.null2String(request.getParameter("orderBy"));
		try {
			Page<Dictionaries> page = dictionariesService.query(pageIndex, pageSize);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	/**
	 * 保存字典 
	 * type+key+value 唯一
	 * type和key不能是中文
	 * @param request
	 * @param dictionaries
	 * @return
	 */
	@RequestMapping(value = "/dictionaries/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> save(HttpServletRequest request,Dictionaries dictionaries) {
		Map<String, Object> result = new HashMap<>();
		result.put("flag", false);
		try{
			Long id=Commutil.null2Long(dictionaries.getId(),-1);
			if(id!=-1){
				//修改
				this.dictionariesService.modify(dictionaries);
				result.put("message", "修改成功");
			}else{
				this.dictionariesService.save(dictionaries);
				result.put("message", "新增成功");
			}
		}catch(Exception e){
			result.put("errorMsg", "操作失败,请联系管理员!");
			log.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 系统菜单管理
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menu.htm", method = RequestMethod.GET)
	public String menuView(HttpServletRequest request){
		return "system/menu";
	}
	/**
	 * 删除菜单(根据菜单ID)
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteMenu(HttpServletRequest request, HttpServletResponse response) {
		Long id = Commutil.null2Long(request.getParameter("id"), -1);
		Map<String, Object> result = new HashMap<>();
		result.put("flag", false);
		try {
			if(id<=0){
				throw new Exception("没有ID");
			}
			this.menuFacadeService.remove(id);
			result.put("flag", true);
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("message", e.getMessage());
		}
		return result;
	}
}
