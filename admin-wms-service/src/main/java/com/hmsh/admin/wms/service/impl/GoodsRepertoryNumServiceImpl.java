package com.hmsh.admin.wms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.BaseService;
import com.hmsh.admin.service.wms.GoodsRepertoryNumFacadeService;
import com.hmsh.admin.vo.wms.GoodsRepertoryNum;
import com.hmsh.admin.wms.dao.GoodsRepertoryNumDao;
@Service
public class GoodsRepertoryNumServiceImpl extends BaseService<GoodsRepertoryNum , Long> implements GoodsRepertoryNumFacadeService{

	@Resource
	private GoodsRepertoryNumDao goodsRepertoryNumDao;

	@Override
	public BaseDao<GoodsRepertoryNum, Long> getDao() {
		return goodsRepertoryNumDao;
	}
	
}
