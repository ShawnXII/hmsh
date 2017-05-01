package com.hmsh.app.service.rule;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.app.dao.rule.JoiningFeeDao;
import com.hmsh.app.service.facade.rule.JoiningFeeFacadeService;

/**
 * 加盟费用表
 * 
 * @author leichao
 *
 */
@Service
public class JoiningFeeService  implements JoiningFeeFacadeService {

	@Resource
	private JoiningFeeDao joiningFeeDao;


}
