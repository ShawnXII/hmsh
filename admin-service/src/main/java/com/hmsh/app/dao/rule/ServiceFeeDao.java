package com.hmsh.app.dao.rule;


import org.springframework.stereotype.Repository;

import com.hmsh.app.vo.rule.ServiceFee;
import com.hmsh.core.base.MongDbDaoImpl;

/**
 * 服务费用
 * @author leichao
 *
 */
@Repository
public class ServiceFeeDao extends MongDbDaoImpl<ServiceFee,Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1426638765040663857L;
	
}