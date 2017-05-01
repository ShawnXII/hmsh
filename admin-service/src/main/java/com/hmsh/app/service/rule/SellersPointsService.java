package com.hmsh.app.service.rule;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.app.dao.rule.SellersPointsDao;
import com.hmsh.app.service.facade.rule.SellersPointsFacadeService;

/**
 * 卖家扣点表
 * @author leichao
 *
 */
@Service
public class SellersPointsService implements SellersPointsFacadeService {
	
	@Resource
	private SellersPointsDao sellersPointsDao;

	

	
}