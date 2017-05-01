package com.hmsh.admin.web.controller.user;

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
import com.hmsh.admin.foundation.domain.system.vo.Resource;
import com.hmsh.admin.foundation.domain.user.vo.Account;
import com.hmsh.admin.foundation.facade.user.AccountFacadeService;
import com.hmsh.admin.util.WebUtil;
import com.hmsh.admin.web.controller.BaseController;

/**
 * 帐号管理
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/user/account")
public class AccountViewController extends BaseController {

	@Autowired
	private AccountFacadeService accountService;
	

	/*@Override
	public String indexPath() {
		return "user/account/index";
	}
	
	@Override
	public void handelSave(Account account) {
		String password=account.getPassword();
		String salt=Commutil.getSalt();
		password=Commutil.encrypt(password, salt);
		account.setPassword(password);
		account.setSalt(salt);
		account.setCreateTime(System.currentTimeMillis());
	}

	@Override
	public BaseFacadeService<Account, Long> getBaseService() {
		return accountService;
	}*/
	
	/**
	 * 系统资源页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/index.htm"},method={RequestMethod.GET})
	public String indexView(HttpServletRequest request, Model model){
		return "user/account/index";
	}
	
	/**
	 * 分页查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"/query"},method={RequestMethod.GET})
	public @ResponseBody  DataTablePage<Account,Long> query(HttpServletRequest request){
		Integer pageIndex = Commutil.null2Int(request.getParameter("pageIndex"), 1);
		Integer pageSize = Commutil.null2Int(request.getParameter("pageSize"), 20);
		String orderBy = Commutil.null2String(request.getParameter("orderBy"));
		try {
			Page<Account> page = accountService.query(pageIndex, pageSize);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
		}
		return null;
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
		if (StringUtils.isBlank(name)) {
			map.put("flag", false);
			map.put("code", "002");
			map.put("errorMsg", "检查值不能为空!");
		}
		boolean flag = false;
		try {
			Account account=new Account();
			account.setUsername(name.trim());
			Long count=this.accountService.queryCount(account);
			flag=count>0;
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
	 * 帐号注册(添加)
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request,Account entity) {
		Map<String, Object> result = new HashMap<>();
		result.put("message", "注册成功");
		result.put("flag", true);
		try {
			String ip=WebUtil.getIp(request);
			entity.setIp(ip);
			this.accountService.register(entity);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			result.put("flag", false);
			result.put("message", e.getMessage());
		}
		return result;
	}

}
