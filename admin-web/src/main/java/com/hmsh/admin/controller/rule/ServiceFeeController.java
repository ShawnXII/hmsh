package com.hmsh.admin.controller.rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.rule.ServiceFee;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 服务费用规则配置
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/service")
public class ServiceFeeController extends BaseController<ServiceFee,Long>{

	@Override
	public BaseFacadeService<ServiceFee, Long> getService() {
		
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("rule/service");
		return mv;
	}

	/*private static final Logger log = LoggerFactory.getLogger(ServiceFeeAction.class);

	@Autowired
	private ServiceFeeFacadeService serviceFeeService;

	*//**
	 * 服务费用规则配置列表
	 * 
	 * @return
	 *//*
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rule/serviceFee/index");
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
	public @ResponseBody DataTablePage<ServiceFee, Long> query(HttpServletRequest request) {
		try {
			QueryParameter<ServiceFee, Long> query = QueryTool.queryParameter(ServiceFee.class);
			Page<ServiceFee> page = serviceFeeService.search(query);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	*//**
	 * 修改或新增服务费用规则配置
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = { "/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public @ResponseBody RequestData delete(@RequestParam("id") Long id) {
		Boolean flag = true;
		String message = "删除成功";
		try {
			this.serviceFeeService.remove(id);
		} catch (ServiceException e) {
			flag = false;
			message = "删除失败:" + e.getMessage();
			log.error("删除服务费用规则配置信息失败", e);
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
	public @ResponseBody ServiceFee getResourceById(@RequestParam Long id) {
		try {
			ServiceFee resource = this.serviceFeeService.findOne(id);
			Assert.notNull(resource, "服务费用规则配置不存在");
			return resource;
		} catch (ServiceException e) {
			log.error("获取服务费用规则配置错误", e);
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
	public @ResponseBody RequestData save(HttpServletRequest request, ServiceFee serviceFee) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			if (serviceFee.getDmId() == null) {
				message = "新增成功!";
			}
			this.serviceFeeService.saveAndModify(serviceFee);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改或新增服务费用规则配置失败", e);
		}
		return new RequestData(flag, message);
	}
	
	@RequestMapping(value = { "/updateState" }, method = RequestMethod.POST)
	public @ResponseBody RequestData updateState(HttpServletRequest request, @RequestParam Long id) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			this.serviceFeeService.updateState(id);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改服务费用规则状态失败", e);
		}
		return new RequestData(flag, message);
	}
*/
}
