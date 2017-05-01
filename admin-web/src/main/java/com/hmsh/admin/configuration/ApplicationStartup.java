package com.hmsh.admin.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.hmsh.admin.service.facade.system.MenuFacadeService;
import com.hmsh.admin.util.SpringUtils;
import com.hmsh.admin.vo.system.Menu;
import com.hmsh.admin.vo.system.Resource;


/**
 * 服务启动执行
 * 
 * @author ShawnXII
 *
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(ApplicationStartup.class);

	private static final Map<String, Object> cacheData = new HashMap<>();
	
	public static final String MENU_KEY="menuList";
	
	public static final String RESOURCE_KEY="resourceList";  
	
	/*
	 * 项目启动加载数据方法 
	 * 更新 和 加载资源 
	 * 加载菜单 
	 * 把系统配置参数都放入到缓存cacheData中
	 *  (non-Javadoc)
	 * @see
	 * org.springframework.context.ApplicationListener#onApplicationEvent(org.
	 * springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadMenu();
		loadReource();
	}
	/**
	 * 加载资源
	 */
	private void loadReource(){
		log.info("################ 准备加载系统资源 ################");
		List<Resource> resourceList=new ArrayList<>(getSystemResource());
		cacheData.put(RESOURCE_KEY, resourceList);
		log.info("################ 系统资源加载成功  ################");
	}
	/**
	 * 获取缓存数据
	 * @return
	 */
	public static Map<String, Object> getCacheData(){
		return cacheData;
	}
	/**
	 * 更新数据
	 * @param key
	 * @param obj
	 */
	public static void updateData(String key,Object obj){
		cacheData.put(key, obj);
	}
	/**
	 * 更新数据
	 * @param key
	 */
	public static void updateData(String key){
		if(MENU_KEY.equals(key)){
			loadMenu();
		}
	}
	/**
	 * 更新数据
	 */
	public static void updateData(){
		updateData(MENU_KEY);
	}	
	/**
	 * 加载菜单数据
	 */
	private static void loadMenu() {
		try {
			log.info("################ 准备加载菜单数据 ################");
			MenuFacadeService menuFacadeService = SpringUtils.getBean(MenuFacadeService.class);
			List<Menu> menuList = menuFacadeService.findAll(new Menu());
			List<Menu> menu = analysisMenu(menuList);
			cacheData.put(MENU_KEY, menu);
			log.info("################ 菜单数据加载成功  ################");
		} catch (Exception e) {
			log.error("################ 菜单数据加载失败  ################", e);
			// 关闭启动
		}
	}

	/**
	 * 递归处理菜单数据
	 * 
	 * @param menuList
	 * @return
	 */
	private static List<Menu> analysisMenu(List<Menu> menuList) {
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

	/**
	 * 递归处理菜单数据
	 * 
	 * @param parentList
	 * @param data
	 */
	private static void menuLoadingSub(List<Menu> parentList, List<Menu> data) {
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

	/**
	 * 递归趋合理菜单数据
	 * 
	 * @param menu
	 * @param list
	 * @return
	 */
	private static List<Menu> getSub(Menu menu, List<Menu> list) {
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
	
	private Set<Resource> getSystemResource() {
		RequestMappingHandlerMapping requestMappingHandlerMapping = SpringUtils.getBean(RequestMappingHandlerMapping.class);
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
		Set<Resource> result = new HashSet<>();
		for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
			RequestMappingInfo info = m.getKey();
			HandlerMethod method = m.getValue();
			RequestMethodsRequestCondition methodCondition = info.getMethodsCondition();
			Resource resource = new Resource();
			String className = method.getBean().toString();// 类名称
			String url = getUri(info);
			Integer type = judgeUrlType(url);
			resource.setName(className);
			resource.setType(type);
			resource.setSequence(0);
			resource.setValue(url);
			resource.setState(0);
			Set<RequestMethod> methods = methodCondition.getMethods();
			resource.setRequestType(getRequestType(methods));// 请求类型
			resource.setMethod(method.getMethod().getName());// 方法名称
			result.add(resource);
		}
		return result;
	}

	/**
	 * 获取请求类型
	 * 
	 * @param methods
	 * @return
	 */
	private String getRequestType(Set<RequestMethod> methods) {
		String requestType = "GET";
		if (methods != null && methods.size() > 0) {
			requestType = "";
			int i = 0;
			for (RequestMethod rm : methods) {
				if (i > 0) {
					requestType += ",";
				}
				i++;
				requestType += rm.name();
				break;
			}
		}
		return requestType;
	}

	/*
	 * 获取注解配置的URL 如果有两个url 则用,分开
	 * 
	 * @return
	 */
	private String getUri(RequestMappingInfo info) {
		PatternsRequestCondition prc = info.getPatternsCondition();
		Set<String> set = prc.getPatterns();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		int i = 0;
		String s = "";
		for (String url : set) {
			// 匹配通配符逻辑可以在这里实现
			if (i == 0) {
				s = url;
			}
			i++;
			String reg = "\\/{1,}";
			url = url.replaceAll(reg, "/");
			if (url.indexOf(".htm") != -1) {
				flag = true;
				sb.append(url);
				break;
			}
		}
		if (!flag) {
			sb.append(s);
		}
		return sb.toString();
	}

	/*
	 * 判断url类型 0:后缀是 htm(页面) 1:资源 通过ajax请求获取数据的url类型
	 */
	private Integer judgeUrlType(String urls) {
		Integer type = 1;
		if (StringUtils.isNotBlank(urls)) {
			String[] arr = urls.split(",");
			for (String url : arr) {
				if (url.indexOf(".htm") != -1) {
					type = 0;
					break;
				}
			}
		}
		return type;
	}

}
