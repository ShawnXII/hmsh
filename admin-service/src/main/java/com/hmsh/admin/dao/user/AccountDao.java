package com.hmsh.admin.dao.user;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.hmsh.admin.vo.user.Account;

public interface AccountDao extends Mapper<Account>{
	
	public List<Account> findAll();
}