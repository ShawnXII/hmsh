package com.hmsh.admin.wms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.BaseService;
import com.hmsh.admin.service.wms.GoodsInfoFacadeService;
import com.hmsh.admin.vo.wms.GoodsInfo;
import com.hmsh.admin.wms.dao.GoodsInfoDao;

@Service
public class GoodsInfoServiceImpl extends BaseService<GoodsInfo , Long> implements GoodsInfoFacadeService{
	
	@Resource
	private GoodsInfoDao goodsInfoDao;

	@Override
	public BaseDao<GoodsInfo, Long> getDao() {
		return goodsInfoDao;
	}
}
