package com.hmsh.app.service.rule;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.app.dao.rule.ConsumptionRecommendBonusDao;
import com.hmsh.app.service.facade.rule.ConsumptionRecommendBonusFacadeService;

/**
 * 推荐人消费额分红表
 * 
 * @author leichao
 *
 */
@Service
public class ConsumptionRecommendBonusService 
		implements ConsumptionRecommendBonusFacadeService {

	@Resource
	private ConsumptionRecommendBonusDao consumptionRecommendBonusDao;

	
}
