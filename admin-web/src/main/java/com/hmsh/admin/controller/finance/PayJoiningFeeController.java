package com.hmsh.admin.controller.finance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.order.PayJoiningFee;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 诚意金管理
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/pjf")
public class PayJoiningFeeController extends BaseController<PayJoiningFee,Long> {

	@Override
	public BaseFacadeService<PayJoiningFee, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("finance/pjf");
		return mv;
	}

	
/*
	@Autowired
	private PayJoiningFeeFacadeService payJoiningFeeService;

	*//**
	 * 诚意金管理列表
	 * @return
	 *//*
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/payJoiningFee/index");
		return mv;
	}

	*//**
	 * 诚意金管理查询
	 * 
	 * @param request
	 * @param goods
	 * @return
	 *//*
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody DataTablePage<PayJoiningFee, Long> query(HttpServletRequest request) {
		try {
			QueryParameter<PayJoiningFee, Long> query = QueryTool.queryParameter(PayJoiningFee.class);
			Page<PayJoiningFee> page = payJoiningFeeService.query(query);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	*//**
	 * 修改或新增诚意金管理
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = { "/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public @ResponseBody RequestData delete(@RequestParam("id") Long id) {
		Boolean flag = true;
		String message = "删除成功";
		try {
			this.payJoiningFeeService.remove(id);
		} catch (ServiceException e) {
			flag = false;
			message = "删除失败:" + e.getMessage();
			log.error("删除提现管理信息失败", e);
		}
		return new RequestData(flag, message);
	}

	*//**
	 * 获取诚意金管理
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public @ResponseBody PayJoiningFee getResourceById(@RequestParam Long id) {
		try {
			PayJoiningFee resource = this.payJoiningFeeService.findOne(id);
			Assert.notNull(resource, "提现管理不存在");
			return resource;
		} catch (ServiceException e) {
			log.error("获取提现管理错误", e);
		}
		return null;
	}

	*//**
	 * 修改或新增诚意金管理
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public @ResponseBody RequestData save(HttpServletRequest request, PayJoiningFee payJoiningFee) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			if (payJoiningFee.getDmId() == null) {
				message = "新增成功!";
			}
			this.payJoiningFeeService.saveAndModify(payJoiningFee);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改或新增提现管理失败", e);
		}
		return new RequestData(flag, message);
	}
*/
}
