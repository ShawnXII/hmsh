package com.hmsh.app.service.rule;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.app.dao.rule.ServiceFeeBonusDao;
import com.hmsh.app.service.facade.rule.ServiceFeeBonusFacadeService;

/**
 * 服务费用分红表
 * 
 * @author leichao
 *
 */
@Service
public class ServiceFeeBonusService implements ServiceFeeBonusFacadeService {

	@Resource
	private ServiceFeeBonusDao serviceFeeBonusDao;

	

}