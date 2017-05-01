package com.hmsh.admin.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.hmsh.admin.core.exception.ServiceException;
import com.hmsh.admin.core.util.Commutil;
import com.hmsh.admin.core.util.DataTablePage;
import com.hmsh.admin.core.util.DataTableUtil;
import com.hmsh.admin.foundation.domain.system.vo.Resource;
import com.hmsh.admin.foundation.domain.system.vo.Role;
import com.hmsh.admin.foundation.facade.BaseFacadeService;
import com.hmsh.admin.foundation.facade.system.ResourceFacadeService;
import com.hmsh.admin.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.Map.Entry;

/**
 * 资源管理
 * 
 * @author ShawnXII
 */
@Controller
@RequestMapping("/system/resource")
public class ResourceViewController extends BaseController {

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@Autowired
	private ResourceFacadeService resourceService;

	/*@Override
	public void handelIndex(HttpServletRequest request, Model model) {
		try {
			model.addAttribute("resourceList", JSON.toJSONString(resourceService.findAll()));
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
	};

	@Override
	public String indexPath() {
		return "system/resource/index";
	}

	@Override
	public BaseFacadeService<Resource, Long> getBaseService() {
		return resourceService;
	}*/
	/**
	 * 系统资源页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/index.htm"},method={RequestMethod.GET})
	public String indexView(HttpServletRequest request, Model model){
		return "system/resource/index";
	}
	/**
	 * 分页查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"/query"},method={RequestMethod.GET})
	public @ResponseBody  DataTablePage<Resource,Long> query(HttpServletRequest request){
		Integer pageIndex = Commutil.null2Int(request.getParameter("pageIndex"), 1);
		Integer pageSize = Commutil.null2Int(request.getParameter("pageSize"), 20);
		String orderBy = Commutil.null2String(request.getParameter("orderBy"));
		try {
			Page<Resource> page = resourceService.query(pageIndex, pageSize);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	/**
	 * 系统资源同步
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/synchronous", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> synchronous(HttpServletRequest request) {
		log.info("=====================系统资源同步开始=============================");
		Map<String, Object> map = new HashMap<>();
		map.put("flag", false);
		try {
			Set<Resource> resourceList = loadResource();
			resourceService.synchronous(resourceList);
			map.put("flag", true);
		} catch (Exception e) {
			log.error("============系统资源同步失败====================", e);
			map.put("errorMsg", e.getMessage());
		}
		log.info("========================系统资源同步结束==================================");
		return map;
	}
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> modify(HttpServletRequest request) {
		Map<String, Object> result= new HashMap<>();
		result.put("flag", true);
		Long id = Commutil.null2Long(request.getParameter("id"), -1);
		String key = Commutil.null2String(request.getParameter("key"));
		String value = Commutil.null2String(request.getParameter("value"));
		try {
			if (id == null || id < 1) {
				throw new Exception("ID 不能为空");
			}
			Resource resource=new Resource();
			resource.setId(id);
			if("info".equals(key)){
				resource.setInfo(value);
			}else{
				resource.setAlias(value);
			}
			this.resourceService.modifyNotNull(resource);
			result.put("message", "修改成功!");
		} catch (Exception e) {
			result.put("flag", false);
			result.put("errorMsg", e.getMessage());
		}
		return result;
	}

	/**
	 * 获取系统资源
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getResourceAllData", method = RequestMethod.GET)
	@ResponseBody
	public List<Resource> getResource(HttpServletRequest request) {
		Byte type = (byte) Commutil.null2Int(request.getParameter("type"), -1);
		Resource resource = new Resource();
		if (type != -1) {
			resource.setType(type);
		}
		resource.setState((byte) 0);
		try {
			return this.resourceService.findAll(resource);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	private Set<Resource> loadResource() {
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
		Set<Resource> resSet = new HashSet<>();
		if (map != null) {
			Set<Entry<RequestMappingInfo, HandlerMethod>> set = map.entrySet();
			Iterator<Entry<RequestMappingInfo, HandlerMethod>> ite = set.iterator();
			while (ite.hasNext()) {
				Entry<RequestMappingInfo, HandlerMethod> entry = ite.next();
				RequestMappingInfo info = entry.getKey();
				HandlerMethod method = entry.getValue();
				String className = method.getBean().toString();
				String urls = getUri(info);
				Resource resource = new Resource();
				resource.setName(className);
				resource.setInfo("同步");
				resource.setValue(urls);
				resource.setType(getResourceType(urls));
				resource.setState((byte) 0);
				resource.setSequence(0);
				resSet.add(resource);
			}
		}
		return resSet;
	}

	/**
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

	/**
	 * 获取资源类型
	 * 
	 * @param urls
	 * @return
	 */
	private Byte getResourceType(String urls) {
		Byte type = 1;
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
