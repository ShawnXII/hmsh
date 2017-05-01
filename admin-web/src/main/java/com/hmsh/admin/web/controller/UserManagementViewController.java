package com.hmsh.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hmsh.admin.foundation.facade.mongo.user.UserFacadeService;

/**
 * 用户管理
 * 功能:
 * 	个人用户
 *  个人认证
 *  商家用户
 *  商家认证
 *  注销用户
 * /user/management
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/user")
public class UserManagementViewController extends BaseController{
	
	@Autowired
	private UserFacadeService userService;
	
	/**
	 * 个人用户
	 * 功能点:
	 * 	查询:关键字查询:手机号/呢称/邀请人;认证类型:全部/已认证/未认证;注册时间段 状态查询
	 *  多个启用/禁用
	 *  table:
	 *  	头像|手机号|性别|认证类型|注册时间|邀请码|邀请人|状态|是否完善|操作:查看订单/查看钱包/编辑/注销/重置号码/被操作记录/查看团队
	 *  后台分页   
	 * @return
	 */
	@RequestMapping(value="/individual.htm",method=RequestMethod.GET)
	public String IndividualUserView(HttpServletRequest request){
		
		return "user/individual";
	}
}
