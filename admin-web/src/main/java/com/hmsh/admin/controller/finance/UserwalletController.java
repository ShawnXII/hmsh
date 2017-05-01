package com.hmsh.admin.controller.finance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.user.Userwallet;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/userwallet")
public class UserwalletController extends BaseController<Userwallet,Long> {

	@Override
	public BaseFacadeService<Userwallet, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("finance/userwallet");
		return mv;
	}

	/*private static final Logger log = LoggerFactory.getLogger(UserwalletAction.class);

	@Autowired
	private UserwalletFacadeService userwalletService;

	*//**
	 * 钱包管理列表
	 * 
	 * @return
	 *//*
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/userwallet/index");
		return mv;
	}

	*//**
	 * 钱包管理查询
	 * 
	 * @param request
	 * @param goods
	 * @return
	 *//*
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody DataTablePage<Userwallet, Long> query(HttpServletRequest request) {
		try {
			QueryParameter<Userwallet, Long> query = QueryTool.queryParameter(Userwallet.class);
			Page<Userwallet> page = userwalletService.queryUserwallet(query);
			return DataTableUtil.pageToDaraTable(page);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	*//**
	 * 修改或新增钱包管理
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = { "/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public @ResponseBody RequestData delete(@RequestParam("id") Long id) {
		Boolean flag = true;
		String message = "删除成功";
		try {
			this.userwalletService.remove(id);
		} catch (ServiceException e) {
			flag = false;
			message = "删除失败:" + e.getMessage();
			log.error("删除推荐人营业额分红规则配置信息失败", e);
		}
		return new RequestData(flag, message);
	}

	*//**
	 * 获取钱包管理
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public @ResponseBody Userwallet getResourceById(@RequestParam Long id) {
		try {
			Userwallet resource = this.userwalletService.findOne(id);
			Assert.notNull(resource, "服务费用规则配置不存在");
			return resource;
		} catch (ServiceException e) {
			log.error("获取推荐人营业额分红规则配置错误", e);
		}
		return null;
	}

	*//**
	 * 修改或新增钱包管理
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public @ResponseBody RequestData save(HttpServletRequest request, Userwallet userwallet) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			if (userwallet.getDmId() == null) {
				message = "新增成功!";
			}
			this.userwalletService.saveAndModify(userwallet);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改或新增推荐人营业额分红规则配置失败", e);
		}
		return new RequestData(flag, message);
	}
*/
}
