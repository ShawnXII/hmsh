package com.hmsh.admin.web.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmsh.admin.foundation.facade.goods.GoodsClassFacadeService;

@Controller
@RequestMapping("/goods/goodsClass")
public class GoodsClassController{

	@Autowired
	private GoodsClassFacadeService goodsClassService;
	
	@RequestMapping("index.html")
	public String indexView(Model model){
		model.addAttribute("goodsClass", goodsClassService.getPage(0, 20, null));
		return "goods/goodsClass/index";
	}
	                     

}
