package com.hmsh.app.service.rule;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.app.dao.rule.ServiceFeeDao;
import com.hmsh.app.service.facade.rule.ServiceFeeFacadeService;

/**
 * 服务费用
 * 
 * @author leichao
 *
 */
@Service
public class ServiceFeeService implements ServiceFeeFacadeService {

	@Resource
	private ServiceFeeDao serviceFeeDao;

	

}