package com.hmsh.admin.controller.finance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.user.UwExtractapply;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 提现管理
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/uwExtractapply")
public class UwExtractapplyController extends BaseController<UwExtractapply, Long> {

	@Override
	public BaseFacadeService<UwExtractapply, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("finance/uwExtractapply");
		return mv;
	}

	/*
	 * private static final Logger log =
	 * LoggerFactory.getLogger(UserwalletAction.class);
	 * 
	 * @Autowired private UwExtractapplyFacadeService uwExtractapplyService;
	 * 
	 *//**
		 * 提现管理列表
		 * 
		 * @return
		 */
	/*
	 * @RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	 * public ModelAndView index() { ModelAndView mv = new ModelAndView();
	 * mv.setViewName("finance/uwExtractapply/index"); return mv; }
	 * 
	 *//**
		 * 提现管理查询
		 * 
		 * @param request
		 * @param goods
		 * @return
		 */
	/*
	 * @RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	 * public @ResponseBody DataTablePage<UwExtractapply, Long>
	 * query(HttpServletRequest request) { try { QueryParameter<UwExtractapply,
	 * Long> query = QueryTool.queryParameter(UwExtractapply.class);
	 * Page<UwExtractapply> page =
	 * uwExtractapplyService.queryUwExtractapply(query); return
	 * DataTableUtil.pageToDaraTable(page); } catch (ServiceException e) {
	 * log.error(e.getMessage(), e); } return null; }
	 * 
	 *//**
		 * 修改或新增提现管理
		 * 
		 * @param id
		 * @return
		 */
	/*
	 * @RequestMapping(value = { "/remove" }, method = { RequestMethod.POST,
	 * RequestMethod.DELETE }) public @ResponseBody RequestData
	 * delete(@RequestParam("id") Long id) { Boolean flag = true; String message
	 * = "删除成功"; try { this.uwExtractapplyService.remove(id); } catch
	 * (ServiceException e) { flag = false; message = "删除失败:" + e.getMessage();
	 * log.error("删除提现管理信息失败", e); } return new RequestData(flag, message); }
	 * 
	 *//**
		 * 获取提现管理
		 * 
		 * @param id
		 * @return
		 */
	/*
	 * @RequestMapping(value = "/findone", method = RequestMethod.GET)
	 * public @ResponseBody UwExtractapply getResourceById(@RequestParam Long
	 * id) { try { UwExtractapply resource =
	 * this.uwExtractapplyService.findOne(id); Assert.notNull(resource,
	 * "提现管理不存在"); return resource; } catch (ServiceException e) {
	 * log.error("获取提现管理错误", e); } return null; }
	 * 
	 *//**
		 * 修改或新增提现管理
		 * 
		 * @param request
		 * @return
		 *//*
		 * @RequestMapping(value = { "/save" }, method = RequestMethod.POST)
		 * public @ResponseBody RequestData save(HttpServletRequest request,
		 * UwExtractapply uwExtractapply) { Boolean flag = true; String message
		 * = "修改成功!"; try { if (uwExtractapply.getDmId() == null) { message =
		 * "新增成功!"; } this.uwExtractapplyService.saveAndModify(uwExtractapply);
		 * } catch (Exception e) { flag = false; message = "修改失败," +
		 * e.getMessage(); log.error("修改或新增提现管理失败", e); } return new
		 * RequestData(flag, message); }
		 */
}
