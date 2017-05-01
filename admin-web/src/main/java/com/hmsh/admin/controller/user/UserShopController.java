package com.hmsh.admin.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.user.UserShop;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 商家用户管理
 * 
 * @author ShawnXII
 */
@Controller
@RequestMapping("/usershop")
public class UserShopController extends BaseController<UserShop,Long> {

	@Override
	public BaseFacadeService<UserShop, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("user/index");
		return mv;
	}

	/*private static final Logger log = LoggerFactory.getLogger(AuthenticationAction.class);

	@Autowired
	private UserShopFacadeService userShopService;

	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userShop");
		return mv;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody DataTablePage<UserShop, Long> qeuryUserShop(HttpServletRequest request) {
		try {
			QueryParameter<UserShop, Long> query = QueryTool.queryParameter(UserShop.class);
			Page<UserShop> page = userShopService.search(query);
			return DataTableUtil.pageToDaraTable(page, query.getDraw());
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}*/
}
