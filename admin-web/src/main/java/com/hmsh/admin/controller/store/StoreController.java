package com.hmsh.admin.controller.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.shop.SellerStore;
import com.hmsh.core.base.service.BaseFacadeService;
/**
 * 店铺管理
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/store")
public class StoreController extends BaseController<SellerStore,Long>{

	@Override
	public BaseFacadeService<SellerStore, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("store/index");
		return mv;
	}
	
	/*private static final Logger log = LoggerFactory.getLogger(StoreAction.class);
	
	@Autowired
	private SellerStoreFacadeService sellerStoreService;
	
	@Autowired
	private SellerStoreOpreateFacadeService sellerStoreOpreateService;
	
	@Autowired
	private UserShopFacadeService userShopService;
	

	*//**
	 * 店铺列表
	 * 
	 * @return
	 *//*
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String sellerStoreView() {
		return "shop/sellerStore";
	}

	*//**
	 * 分页查询店铺列表
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody DataTablePage<SellerStore, Long> querySellerStoreList(HttpServletRequest request) {
		try {
			QueryParameter<SellerStore, Long> query = QueryTool.queryParameter(SellerStore.class);
			Page<SellerStore> page = sellerStoreService.querySellerStore(query);
			return DataTableUtil.pageToDaraTable(page, query.getDraw());
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	*//**
	 * 分页查询店铺操作日志列表
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "/queryOpreate", method = RequestMethod.GET)
	public @ResponseBody DataTablePage<SellerStoreOpreate, Long> querySellerStoreOpreateList(
			HttpServletRequest request) {
		try {
			// 参数待定
			QueryParameter<SellerStoreOpreate, Long> query = QueryTool.queryParameter(SellerStoreOpreate.class);
			Page<SellerStoreOpreate> page = sellerStoreOpreateService.query(query);
			return DataTableUtil.pageToDaraTable(page, query.getDraw());
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	*//**
	 * 修改店铺启动禁用(包括批量','分割)
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "/sellerStore/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveSellerStore(HttpServletRequest request, SellerStore sellerStore) {
		Map<String, Object> result = new HashMap<>();
		result.put("flag", true);
		try {
			String dmIds = sellerStore.getDmIds();
			if (StringUtils.isNotBlank(dmIds)) {
				Integer state = sellerStore.getStatus();
				List<SellerStore> sellerList = new ArrayList<>();
				List<SellerStoreOpreate> opreateList = new ArrayList<>();
				List<UserShop> userShopList = new ArrayList<>();
				String[] arrs = dmIds.split(",");
				for (String arr : arrs) {
					Long id = Commutil.null2Long(arr, -1);
					if (id < 0) {
						continue;
					}
					SellerStore seller = this.sellerStoreService.findOne(id);
					if (seller == null || seller.getDmId() == null) {
						continue;
					}
					SellerStoreOpreate opreate = new SellerStoreOpreate();
					seller.setStatus(state);
					String message = state == 2 ? "手动关闭店铺" : "手动启用店铺";
					if (state == 2) {
						seller.setMsgInfo(sellerStore.getMsgInfo());
					}
					opreate.setOperateChange(message);
					opreate.setOperateContent(sellerStore.getMsgInfo());
					opreate.setSellerId(id);
					if (seller.getUserId() != null) {
						UserShop userShop = userShopService.findOne(seller.getUserId());
						if (userShop != null) {
							userShop.setIsStore(state);
							userShopList.add(userShop);
						}
					}
					opreateList.add(opreate);
					sellerList.add(seller);
				}
				if (sellerList != null && sellerList.size() > 0) {
					sellerStoreService.batchModify(sellerList);
					sellerStoreOpreateService.batchSave(opreateList);
				}
				if (userShopList != null && userShopList.size() > 0) {
					this.userShopService.batchModify(userShopList);
				}
			}
			result.put("message", "修改成功!");
		} catch (Exception e) {
			result.put("flag", false);
			result.put("errorMsg", e.getMessage());
		}
		return result;
	}

	*//**
	 * 匹配运营图
	 * 
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "/fitSysImg/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveFitSysImg(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		result.put("flag", true);
		try {
			Long dmId = Commutil.null2Long(request.getParameter("dmId"));
			UserShop userShop = userShopService.findOne(dmId);
			if (userShop != null) {
				result.put("message", "修改成功!");
				/// ShopAction fitSysImg
			} else {
				result.put("message", "运营图已全部匹配完毕!");
				result.put("flag", false);
				return result;
			}
		} catch (Exception e) {
			result.put("flag", false);
			result.put("errorMsg", e.getMessage());
		}
		return result;
	}*/

}
