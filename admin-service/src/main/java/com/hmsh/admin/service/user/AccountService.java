package com.hmsh.admin.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.abel533.entity.Example;
import com.hmsh.admin.dao.user.AccountDao;
import com.hmsh.admin.dao.user.AccountSecurityLogDao;
import com.hmsh.admin.dao.user.UserInfoDao;
import com.hmsh.admin.service.facade.user.AccountFacadeService;
import com.hmsh.admin.vo.system.Role;
import com.hmsh.admin.vo.user.Account;
import com.hmsh.admin.vo.user.AccountSecurityLog;
import com.hmsh.admin.vo.user.EventCode;
import com.hmsh.admin.vo.user.UserInfo;
import com.hmsh.core.base.vo.ValidationResult;
import com.hmsh.core.exception.ServiceException;
import com.hmsh.core.tool.Commutil;
import com.hmsh.core.tool.ValidationUtils;

/**
 * 帐号管理
 * 
 * @author ShawnXII
 *
 */
@Service
public class AccountService implements AccountFacadeService {

	@Resource
	private AccountDao accountDao;

	@Resource
	private UserInfoDao userInfoDao;

	@Resource
	private AccountSecurityLogDao accountSecurityLogDao;

	@Override
	public Account loadUserByUsername(String username) throws UsernameNotFoundException {
		Account result = null;
		Example example = new Example(Account.class);
		example.createCriteria().andEqualTo("username", username);
		List<Account> list = this.accountDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			int i = 0;
			for (Account account : list) {
				result = account;
				if (account.getState() != 2) {
					result = account;
					i++;
				}
			}
			if (i == 0 && result == null) {
				throw new UsernameNotFoundException("用户不存在!");
			} else if (i > 1) {
				throw new UsernameNotFoundException("用户异常!");
			} else if (i == 1 && result != null && result.getState() != 0) {
				throw new UsernameNotFoundException("用户状态异常,已经被限制登录!");
			}
		}
		return result;
	}

	@Override
	public Account registered(Account account) throws ServiceException {
		Assert.notNull(account, "注册用户不能为空!");
		if (account.getId() == null) {
			account.setId(Commutil.generateId());
		}
		String salt = Commutil.getSalt();
		account.setSalt(salt);
		String password1 = account.getPassword();
		String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){4,20}$";
		Assert.isTrue(password1.matches(regStr), "4-20 位，字母、数字、字符,密码格式错误!");
		String password = Commutil.encrypt(password1, salt);
		account.setPassword(password);
		account.setDefault();
		account.setIsModifyPassword(0);
		UserInfo userInfo = account.getUserInfo();
		if (userInfo == null) {
			userInfo = new UserInfo();
		}
		if (userInfo.getId() == null) {
			userInfo.setId(Commutil.generateId());
		}
		userInfo.setAccountId(account.getId());
		// 添加用户权限
		if (account.getAuthorities() != null && account.getAuthorities().size() > 0) {

		}
		// 用户日志添加
		account.setPassword(password1);
		account.setSalt("");
		AccountSecurityLog alog = new AccountSecurityLog(EventCode.REGISTER);
		alog.setId(Commutil.generateId());
		alog.setEventData(account);
		alog.setUsername(account.getUsername());
		alog.setIp(account.getIp());
		this.accountDao.insert(account);
		this.userInfoDao.insert(userInfo);

		// 字段校验
		ValidationResult result = ValidationUtils.validateEntity(account);
		Assert.isTrue(!result.isHasErrors(), result.toString());
		result = ValidationUtils.validateEntity(userInfo);
		Assert.isTrue(!result.isHasErrors(), result.toString());
		result = ValidationUtils.validateEntity(alog);
		Assert.isTrue(!result.isHasErrors(), result.toString());
		this.accountSecurityLogDao.insert(alog);
		return account;
	}

	@Override
	public void updatePassword(Long id, String oldPassword, String newPassword) throws ServiceException {
		try{
			Account account=this.accountDao.selectByPrimaryKey(id);
			Assert.notNull(account, "用户不存在");
			String salt=account.getSalt();
			String password=account.getPassword();
			oldPassword=Commutil.encrypt(oldPassword, salt);
			Assert.isTrue(oldPassword.equals(password),"密码错误!");
			newPassword=Commutil.encrypt(newPassword, salt);
			account.setPassword(newPassword);
			account.setIsModifyPassword(1);
			this.accountDao.updateByPrimaryKey(account);
		}catch(Exception e){
			throw new ServiceException(e);
		}	
	}

	@Override
	public void setRole(Long accountId, List<Role> roles) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Long... longs) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateState(Long id, Integer state) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Account account) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public String resetPassword(Long... longs) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loginIn(Account account) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginOut(Account account) throws ServiceException {
		
	}

	
	public Page<Account> query(Account example) {
		// TODO Auto-generated method stub
		return null;
	}

}
