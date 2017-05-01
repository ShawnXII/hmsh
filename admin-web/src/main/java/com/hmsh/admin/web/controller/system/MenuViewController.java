package com.hmsh.admin.web.controller.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hmsh.admin.core.exception.ServiceException;
import com.hmsh.admin.core.util.Commutil;
import com.hmsh.admin.foundation.domain.system.vo.Menu;
import com.hmsh.admin.foundation.facade.system.MenuFacadeService;
import com.hmsh.admin.web.controller.BaseController;

/**
 * 系统菜单控制器
 * 
 * @author ShawnXII
 */
@Controller
@RequestMapping("/system/menu")
public class MenuViewController extends BaseController {

	@Autowired
	private MenuFacadeService menuFacadeService;

	/**
	 * 菜单主页
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/index.htm" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String indexView(HttpServletRequest request, Model model) {
		/*String requestType = request.getHeader("X-Requested-With");
		System.out.println("requestType:"+requestType);*/
		return "system/menu/index";
	}

	/**
	 * 保存或者修改菜单 权限分配[管理员]
	 * @param menu
	 * @return
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> save(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		result.put("flag", false);
		try{
			String title=Commutil.null2String(request.getParameter("title"));
			String target=Commutil.null2String(request.getParameter("target"),"");
			Byte state=(byte) Commutil.null2Int(request.getParameter("state"),0);
			Integer level=Commutil.null2Int(request.getParameter("level"),0);
			String icon=Commutil.null2String(request.getParameter("icon"),"");
			String url=Commutil.null2String(request.getParameter("url"),"");
			Long parentId=Commutil.null2Long(request.getParameter("parentId"),-1);
			String info=Commutil.null2String(request.getParameter("info"));
			Long id=Commutil.null2Long(request.getParameter("id"),-1);
			Integer sequence=Commutil.null2Int(request.getParameter("sequence"),0);
			Menu menu=new Menu();
			level=(level==0&&parentId!=-1)?1:level;
			icon="请选择".equals(icon)?"":icon;
			url="请选择".equals(url)?"":url;
			menu.setLevel(level);
			if(parentId!=-1){
				menu.setParentId(parentId);
			}
			menu.setIcon(icon);
			menu.setUrl(url);
			state=state<0?0:state;
			menu.setState(state);
			Assert.isTrue(StringUtils.isNotBlank(title),"菜单标题不能为空");
			menu.setTitle(title);
			menu.setTarget(target);
			menu.setInfo(info);
			menu.setSequence(sequence);
			if(id!=-1){
				//修改
				menu.setId(id);
				this.menuFacadeService.modify(menu);
				result.put("message", "修改成功");
			}else{
				this.menuFacadeService.save(menu);
				result.put("message", "新增成功");
			}
		}catch(Exception e){
			result.put("errorMsg", "操作失败,请联系管理员!");
			log.error(e.getMessage());
		}
		return result;

	}

	/**
	 * 检查值是否存在
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
		String name = Commutil.null2String(request.getParameter("name"));
		Long parentId = Commutil.null2Long(request.getParameter("parentId"), -1);
		Long id = Commutil.null2Long(request.getParameter("id"), -1);
		if (StringUtils.isBlank(name)) {
			map.put("flag", false);
			map.put("code", "002");
			map.put("errorMsg", "检查值不能为空!");
		}
		boolean flag = false;
		try {
			Menu menu = new Menu();
			menu.setTitle(name);
			if (parentId != -1) {
				menu.setParentId(parentId);
			}
			/*if (id != -1) {
				menu.setId(id);
			}*/
			List<Menu> result=menuFacadeService.findAll(menu);
			if(result!=null&&result.size()>0){
				for(Menu m:result){
					if(m.getId().longValue()!=id.longValue()){
						flag=true;
						break;
					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (!flag) {
			map.put("flag", true);
			map.put("code", "000");
			map.put("errorMsg", "");
		}
		return map;
	}

	/**
	 * 获取全部数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getMenuAllData", method = RequestMethod.GET)
	@ResponseBody
	public List<Menu> getMenuAllData() {
		List<Menu> result = new ArrayList<>();
		// 获取全部菜单
		try {
			List<Menu> list = this.menuFacadeService.findAll();
			return analysisMenu(list);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	

	private List<Menu> analysisMenu(List<Menu> menuList) {
		List<Menu> firstList = new ArrayList<>();
		if (menuList != null && menuList.size() > 0) {
			Iterator<Menu> ite = menuList.iterator();
			while (ite.hasNext()) {
				Menu menu = ite.next();
				if (menu.getSequence() == null) {
					menu.setSequence(0);
				}
				if (menu.getParentId() == null) {
					firstList.add(menu);
					ite.remove();
				}
			}
			Collections.sort(firstList);
			menuLoadingSub(firstList, menuList);
		}
		return firstList;
	}

	private void menuLoadingSub(List<Menu> parentList, List<Menu> data) {
		if (parentList.isEmpty() || data.isEmpty()) {
			return;
		}
		for (Menu menu : parentList) {
			List<Menu> sublist = getSub(menu, data);
			if (sublist != null && sublist.size() > 0) {
				menu.setChilds(sublist);
				menuLoadingSub(sublist, data);
			}
		}
	}

	private List<Menu> getSub(Menu menu, List<Menu> list) {
		if (list.isEmpty()) {
			return null;
		}
		List<Menu> data = new ArrayList<>();
		Iterator<Menu> ite = list.iterator();
		while (ite.hasNext()) {
			Menu sub = ite.next();
			if (sub.getSequence() == null) {
				sub.setSequence(0);
			}
			Long parentId = sub.getParentId();
			if (parentId.longValue() == menu.getId().longValue()) {
				data.add(sub);
				ite.remove();
			}
		}
		Collections.sort(data);
		return data;
	}
}
