package com.hmsh.admin.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.user.UserPerson;
import com.hmsh.core.base.service.BaseFacadeService;
/**
 * 个人/商家 认证
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/userperson")
public class UserPersonController extends BaseController<UserPerson,Long> {

	@Override
	public BaseFacadeService<UserPerson, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("user/userperson");
		return mv;
	}
	
	/*private static final Logger log = LoggerFactory.getLogger(AuthenticationAction.class);
	
	@Autowired
	private UserPersonFacadeService userPersonService;
	
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/authentication");
		return mv;
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody DataTablePage<UserPerson,Long> qeuryAuthentication(HttpServletRequest request) {
		try {	
			QueryParameter<UserPerson, Long>  query=QueryTool.queryParameter(UserPerson.class);
			Page<UserPerson> page = userPersonService.search(query);
			return DataTableUtil.pageToDaraTable(page,query.getDraw());
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	*/
}
