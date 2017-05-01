package com.hmsh.app.dao.rule;

import org.springframework.stereotype.Repository;

import com.hmsh.app.vo.rule.SellersPoints;
import com.hmsh.core.base.MongDbDaoImpl;

/**
 * 卖家扣点表
 * 
 * @author leichao
 *
 */
@Repository
public class SellersPointsDao extends MongDbDaoImpl<SellersPoints, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8395943087737716686L;
}