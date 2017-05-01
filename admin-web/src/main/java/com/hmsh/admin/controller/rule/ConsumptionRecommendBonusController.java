package com.hmsh.admin.controller.rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.rule.ConsumptionRecommendBonus;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 推荐人消费额分红规则配置
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/crb")
public class ConsumptionRecommendBonusController extends BaseController<ConsumptionRecommendBonus, Long> {

	@Override
	public BaseFacadeService<ConsumptionRecommendBonus, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("rule/crb");
		return mv;
	}

	/*
	 * private static final Logger log =
	 * LoggerFactory.getLogger(ConsumptionRecommendBonusAction.class);
	 * 
	 * @Autowired private ConsumptionRecommendBonusFacadeService
	 * consumptionRecommendBonusService;
	 * 
	 *//**
		 * 推荐人消费额分红规则配置
		 * 
		 * @return
		 */
	/*
	 * @RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	 * public ModelAndView index() { ModelAndView mv = new ModelAndView();
	 * mv.setViewName("rule/consumptionRecommendBonus/index");
	 * 
	 * return mv; }
	 * 
	 *//**
		 * 推荐人消费额分红规则配置查询
		 * 
		 * @param request
		 * @param goods
		 * @return
		 */
	/*
	 * @RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	 * public @ResponseBody Page<ConsumptionRecommendBonus>
	 * query(HttpServletRequest request,ConsumptionRecommendBonus
	 * consumptionRecommendBonus) { try { return
	 * consumptionRecommendBonusService.query(consumptionRecommendBonus); }
	 * catch (ServiceException e) { log.error(e.getMessage(), e); } return null;
	 * }
	 * 
	 *//**
		 * 修改或新增推荐人消费额分红规则删除
		 * 
		 * @param id
		 * @return
		 */
	/*
	 * @RequestMapping(value = { "/remove" }, method = { RequestMethod.POST,
	 * RequestMethod.DELETE }) public @ResponseBody RequestData
	 * delete(@RequestParam("id") Long id) { Boolean flag = true; String message
	 * = "删除成功"; try { this.consumptionRecommendBonusService.remove(id); } catch
	 * (ServiceException e) { flag = false; message = "删除失败:" + e.getMessage();
	 * log.error("删除推荐人消费额分红规则信息失败", e); } return new RequestData(flag,
	 * message); }
	 * 
	 *//**
		 * 获取推荐人消费额分红规则配置
		 * 
		 * @param id
		 * @return
		 */
	/*
	 * @RequestMapping(value = "/findone", method = RequestMethod.GET)
	 * public @ResponseBody ConsumptionRecommendBonus
	 * getResourceById(@RequestParam Long id) { try { ConsumptionRecommendBonus
	 * resource = this.consumptionRecommendBonusService.findOne(id);
	 * Assert.notNull(resource, "推荐人消费额分红规则配置不存在"); return resource; } catch
	 * (ServiceException e) { log.error("获取资源错误", e); } return null; }
	 * 
	 *//**
		 * 修改或新增推荐人消费额分红规则
		 * 
		 * @param request
		 * @return
		 */
	/*
	 * @RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	 * public @ResponseBody RequestData save(HttpServletRequest request,
	 * ConsumptionRecommendBonus consumptionRecommendBonus) { Boolean flag =
	 * true; String message = "修改成功!"; try { if
	 * (consumptionRecommendBonus.getDmId() == null) { message = "新增成功!";
	 * this.consumptionRecommendBonusService.add(consumptionRecommendBonus); }
	 * else { this.consumptionRecommendBonusService.updateNotNull(
	 * consumptionRecommendBonus); } } catch (Exception e) { flag = false;
	 * message = "修改失败," + e.getMessage(); log.error("修改或新增推荐人消费额分红规则失败", e); }
	 * return new RequestData(flag, message); }
	 * 
	 *//**
		 * 修改状态
		 * 
		 * @param request
		 * @param row
		 * @return
		 *//*
		 * @RequestMapping(value = { "/updateState" }, method =
		 * RequestMethod.POST) public @ResponseBody RequestData
		 * updateState(HttpServletRequest request, @RequestParam Long id) {
		 * Boolean flag = true; String message = "修改成功!"; try {
		 * ConsumptionRecommendBonus consumptionRecommendBonus=new
		 * ConsumptionRecommendBonus();
		 * this.consumptionRecommendBonusService.update(
		 * consumptionRecommendBonus); } catch (Exception e) { flag = false;
		 * message = "修改失败," + e.getMessage(); log.error("修改推荐人消费额分红规则状态失败", e);
		 * } return new RequestData(flag, message); }
		 */
}
