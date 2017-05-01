package com.hmsh.app.service.rule;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.app.dao.rule.TurnoverRecommendBonusDao;
import com.hmsh.app.service.facade.rule.TurnoverRecommendBonusFacadeService;


/**
 * 推荐人营业额分红表
 * @author leichao
 *
 */
@Service
public class TurnoverRecommendBonusService  implements TurnoverRecommendBonusFacadeService {
	
	@Resource
	private TurnoverRecommendBonusDao turnoverRecommendBonusDao;

	

	
}