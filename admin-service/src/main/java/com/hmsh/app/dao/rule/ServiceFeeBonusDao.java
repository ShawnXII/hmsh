package com.hmsh.app.dao.rule;

import org.springframework.stereotype.Repository;

import com.hmsh.app.vo.rule.ServiceFeeBonus;
import com.hmsh.core.base.MongDbDaoImpl;

/**
 * 服务费用分红表
 * 
 * @author leichao
 *
 */
@Repository
public class ServiceFeeBonusDao extends MongDbDaoImpl<ServiceFeeBonus, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6440792971185584352L;
}