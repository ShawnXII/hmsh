package com.hmsh.admin.service.facade.user;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.hmsh.admin.vo.system.Role;
import com.hmsh.admin.vo.user.Account;
import com.hmsh.core.exception.ServiceException;

/**
 * 帐号管理接口
 * 
 * @author ShawnXII
 *
 */
public interface AccountFacadeService extends UserDetailsService {
	/**
	 * 注册
	 * 
	 * @param account
	 * @return
	 * @throws ServiceException
	 */
	Account registered(Account account) throws ServiceException;

	/**
	 * 修改密码
	 * 
	 * @param id
	 *            用户ID
	 * @param oldPassword
	 *            旧密码
	 * @param newPassword
	 *            新密码
	 * @return
	 * @throws ServiceException
	 */
	void updatePassword(Long id, String oldPassword, String newPassword) throws ServiceException;

	/**
	 * 设置角色
	 * 
	 * @param accountId
	 *            用户
	 * @param roles
	 *            角色
	 * @throws ServiceException
	 */
	void setRole(Long accountId, List<Role> roles) throws ServiceException;

	/**
	 * 删除用户（更改状态为2）
	 * 
	 * @param longs
	 *            用户ID
	 */
	void remove(Long... longs) throws ServiceException;

	/**
	 * 更改状态
	 * 
	 * @param id
	 * @param state
	 */
	void updateState(Long id, Integer state) throws ServiceException;

	/**
	 * 用户修改（不能修改状态，类别，密码，盐值）
	 * 
	 * @param account
	 */
	void update(Account account) throws ServiceException;

	/**
	 * 重置密码(用户登录后会要求重新修改成自己的密码) 重置密码随机生成 同一个修改批次的帐号 密码相同
	 * 
	 * @param longs
	 * @return 随机密码值
	 */
	String resetPassword(Long... longs) throws ServiceException;

	/**
	 * 用户登录
	 * 
	 * @param account
	 * @throws ServiceException
	 */
	void loginIn(Account account) throws ServiceException;

	/**
	 * 用户退出登录
	 * 
	 * @param account
	 * @throws ServiceException
	 */
	void loginOut(Account account) throws ServiceException;

	
	
}
