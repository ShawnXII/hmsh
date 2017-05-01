package com.hmsh.app.dao.rule;


import org.springframework.stereotype.Repository;

import com.hmsh.app.vo.rule.JoiningFee;
import com.hmsh.core.base.MongDbDaoImpl;

/**
 * 加盟费用表
 * @author leichao
 *
 */
@Repository
public class JoiningFeeDao  extends MongDbDaoImpl<JoiningFee,Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1068233265320423367L;
}
