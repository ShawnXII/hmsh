package com.hmsh.admin.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.user.User;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 个人用户管理
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/user")
public class UserConrtroller extends BaseController<User,Long> {

	@Override
	public BaseFacadeService<User, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("user/index");
		return mv;
	}
	
	/*@Autowired
	private UserFacadeService userService;
	
	private static final Logger log = LoggerFactory.getLogger(IndividualAction.class);
	*//**
	 * 服务费用规则配置列表
	 * 
	 * @return
	 *//*
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/individual");
		return mv;
	}

	*//**
	 * 服务费用规则配置查询
	 * 
	 * @param request
	 * @param goods
	 * @return
	 *//*
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody DataTablePage<User, Long> query(HttpServletRequest request) {
		try {
			QueryParameter<User, Long> query = QueryTool.queryParameter(User.class);
			Page<User> page = userService.search(query);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	*//**
	 * 获取个人用户
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public @ResponseBody User getResourceById(@RequestParam Long id) {
		try {
			User resource = this.userService.findOne(id);
			Assert.notNull(resource, "个人用户不存在");
			return resource;
		} catch (ServiceException e) {
			log.error("获取个人用户信息错误", e);
		}
		return null;
	}

	*//**
	 * 修改或新增服务费用规则配置
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public @ResponseBody RequestData save(HttpServletRequest request, User user) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			if (user.getDmId() == null) {
				message = "新增成功!";
			}
			this.userService.saveAndModify(user);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改或新增个人用户配置失败", e);
		}
		return new RequestData(flag, message);
	}
	
	*//**
	 * 个人注册用户报表
	 * 以时间为节点 查询
	 */
	
}
