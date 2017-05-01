package com.hmsh.admin.controller.rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.rule.SellersPoints;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 卖家扣点规则配置
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/sellers")
public class SellersPointsController extends BaseController<SellersPoints,Long>{

	@Override
	public BaseFacadeService<SellersPoints, Long> getService() {
		
		return null;
	}
	
	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("rule/sellers");
		return mv;
	}

	/*private static final Logger log = LoggerFactory.getLogger(SellersPointsAction.class);

	@Autowired
	private SellersPointsFacadeService sellersPointsService;

	*//**
	 * 卖家扣点规则配置列表
	 * 
	 * @return
	 *//*
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rule/sellersPoints/index");
		return mv;
	}

	*//**
	 * 卖家扣点规则配置查询
	 * 
	 * @param request
	 * @param goods
	 * @return
	 *//*
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody DataTablePage<SellersPoints, Long> query(HttpServletRequest request) {
		try {
			QueryParameter<SellersPoints, Long> query = QueryTool.queryParameter(SellersPoints.class);
			Page<SellersPoints> page = sellersPointsService.search(query);
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
			this.sellersPointsService.remove(id);
		} catch (ServiceException e) {
			flag = false;
			message = "删除失败:" + e.getMessage();
			log.error("删除卖家扣点规则配置信息失败", e);
		}
		return new RequestData(flag, message);
	}

	*//**
	 * 获取卖家扣点规则配置
	 * 
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public @ResponseBody SellersPoints getResourceById(@RequestParam Long id) {
		try {
			SellersPoints resource = this.sellersPointsService.findOne(id);
			Assert.notNull(resource, "资源不存在");
			return resource;
		} catch (ServiceException e) {
			log.error("获取卖家扣点规则配置错误", e);
		}
		return null;
	}

	*//**
	 * 修改或新增卖家扣点规则配置
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public @ResponseBody RequestData save(HttpServletRequest request, SellersPoints sellersPoints) {
		Boolean flag = true;
		String message = "修改成功!";
		try {
			if (sellersPoints.getDmId() == null) {
				message = "新增成功!";
			}
			this.sellersPointsService.saveAndModify(sellersPoints);
		} catch (Exception e) {
			flag = false;
			message = "修改失败," + e.getMessage();
			log.error("修改或新增卖家扣点规则配置失败", e);
		}
		return new RequestData(flag, message);
	}
	*/
	
}
