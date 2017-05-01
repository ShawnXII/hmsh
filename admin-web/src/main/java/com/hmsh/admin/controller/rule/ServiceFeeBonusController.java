package com.hmsh.admin.controller.rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.rule.ServiceFeeBonus;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 服务费用分红规则配置
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/sfb")
public class ServiceFeeBonusController extends BaseController<ServiceFeeBonus,Long> {

	@Override
	public BaseFacadeService<ServiceFeeBonus, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("rule/sfb");
		return mv;
	}

	/*private static final Logger log = LoggerFactory.getLogger(ServiceFeeBonusAction.class);

	@Autowired
	private ServiceFeeBonusFacadeService serviceFeeBonusService;

	*//**
	 * 服务费用分红规则配置列表
	 * 
	 * @return
	 *//*
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rule/serviceFeeBonus/index");
		return mv;
	}

	*//**
	 * 服务费用分红规则配置查询
	 * 
	 * @param request
	 * @param goods
	 * @return
	 *//*
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody DataTablePage<ServiceFeeBonus, Long> query(HttpServletRequest request) {
		try {
			QueryParameter<ServiceFeeBonus, Long> query = QueryTool.queryParameter(ServiceFeeBonus.class);
			Page<ServiceFeeBonus> page = serviceFeeBonusService.search(query);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	*//**
	 * 修改或新增卖家扣点规则配置
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = { "/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public @ResponseBody RequestData delete(@RequestParam("id") Long id) {
		Boolean flag = true;
		String message = "删除成功";
		try {
			this.serviceFeeBonusService.remove(id);
		} catch (ServiceException e) {
			flag = false;
			message = "删除失败:" + e.getMessage();
			log.error("删除服务费用分红规则配置信息失败", e);
		}
		return new RequestData(flag, message);
	}

	*//**
	 * 获取服务费用分红规则配置
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public @ResponseBody ServiceFeeBonus getResourceById(@RequestParam Long id) {
		try {
			ServiceFeeBonus resource = this.serviceFeeBonusService.findOne(id);
			Assert.notNull(resource, "资源不存在");
			return resource;
		} catch (ServiceException e) {
			log.error("获取服务费用分红规则配置错误", e);
		}
		return null;
	}

	*//**
	 * 修改或新增服务费用分红规则配置
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public @ResponseBody RequestData save(HttpServletRequest request, ServiceFeeBonus serviceFeeBonus) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			if (serviceFeeBonus.getDmId() == null) {
				message = "新增成功!";
			}
			this.serviceFeeBonusService.saveAndModify(serviceFeeBonus);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改或新增服务费用分红规则配置失败", e);
		}
		return new RequestData(flag, message);
	}
	
	@RequestMapping(value = { "/updateState" }, method = RequestMethod.POST)
	public @ResponseBody RequestData updateState(HttpServletRequest request, @RequestParam Long id) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			this.serviceFeeBonusService.updateState(id);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改服务费用规则状态失败", e);
		}
		return new RequestData(flag, message);
	}
*/
}
