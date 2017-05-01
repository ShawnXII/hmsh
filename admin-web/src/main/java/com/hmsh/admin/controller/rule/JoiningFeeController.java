package com.hmsh.admin.controller.rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.rule.JoiningFee;
import com.hmsh.core.base.service.BaseFacadeService;



/**
 * 加盟费用规则
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/joining")
public class JoiningFeeController  extends BaseController<JoiningFee,Long>{

	@Override
	public BaseFacadeService<JoiningFee, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("rule/joining");
		return mv;
	}

	/*private static final Logger log = LoggerFactory.getLogger(JoiningFeeAction.class);

	@Autowired
	private JoiningFeeFacadeService joiningFeeService;

	*//**
	 * 加盟费用规则列表
	 * 
	 * @return
	 *//*
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rule/joiningFee/index");
		return mv;
	}

	*//**
	 * 加盟费用规则查询
	 * 
	 * @param request
	 * @param goods
	 * @return
	 *//*
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody Page<JoiningFee> query(JoiningFee joiningFee) {
		try {
			return joiningFeeService.query(joiningFee);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	*//**
	 * 修改或新增加盟费用规则
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = { "/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public @ResponseBody RequestData delete(@RequestParam("id") Long id) {
		Boolean flag = true;
		String message = "删除成功";
		try {
			this.joiningFeeService.remove(id);
		} catch (ServiceException e) {
			flag = false;
			message = "删除失败:" + e.getMessage();
			log.error("删除推荐人消费额分红规则信息失败", e);
		}
		return new RequestData(flag, message);
	}

	*//**
	 * 获取加盟费用规则
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public @ResponseBody JoiningFee getResourceById(@RequestParam Long id) {
		try {
			JoiningFee resource = this.joiningFeeService.findOne(id);
			Assert.notNull(resource, "加盟费用规则不存在");
			return resource;
		} catch (ServiceException e) {
			log.error("获取加盟费用规则错误", e);
		}
		return null;
	}

	*//**
	 * 修改或新增加盟费用规则
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public @ResponseBody RequestData save(HttpServletRequest request, JoiningFee joiningFee) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			if (joiningFee.getDmId() == null) {
				message = "新增成功!";
			}
			//this.joiningFeeService.saveAndModify(joiningFee);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改或新增加盟费用规则失败", e);
		}
		return new RequestData(flag, message);
	}
	
	*//**
	 * 修改状态
	 * 
	 * @param request
	 * @param row
	 * @return
	 *//*
	@RequestMapping(value = { "/updateState" }, method = RequestMethod.POST)
	public @ResponseBody RequestData updateState(HttpServletRequest request, @RequestParam Long id) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			//this.joiningFeeService.updateState(id);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改加盟费用规则状态失败", e);
		}
		return new RequestData(flag, message);
	}*/
}
