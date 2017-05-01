package com.hmsh.admin.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.hmsh.admin.core.exception.ServiceException;
import com.hmsh.admin.foundation.domain.system.vo.Menu;
import com.hmsh.admin.foundation.facade.system.MenuFacadeService;
/**
 * 主页
 * 加载菜单数据
 * @author ShawnXII
 */
@Controller
public class IndexViewController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexViewController.class);
	
	@Autowired
	private MenuFacadeService menuFacadeService;
	
	@RequestMapping(value = {"/","/index.htm"},method=RequestMethod.GET)
	public String indexView(Model model){
		model.addAttribute("title", "主页");
		try {
			List<Menu> list = this.menuFacadeService.findAll();
			List<Menu> menuList=analysisMenu(list);
			model.addAttribute("menuJson", JSON.toJSONString(menuList));
		} catch (ServiceException e) {
			log.error("获取菜单数据", e);
		}
		return "index";
	}
	
	
	private List<Menu> analysisMenu(List<Menu> menuList) {
		List<Menu> firstList = new ArrayList<>();
		if (menuList != null && menuList.size() > 0) {
			Iterator<Menu> ite = menuList.iterator();
			while (ite.hasNext()) {
				Menu menu = ite.next();
				if(menu.getSequence()==null){
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
			if(sub.getSequence()==null){
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
