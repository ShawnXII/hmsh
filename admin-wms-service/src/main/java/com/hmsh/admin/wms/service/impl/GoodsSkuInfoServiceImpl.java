package com.hmsh.admin.wms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.BaseService;
import com.hmsh.admin.service.wms.GoodsSkuInfoFacadeService;
import com.hmsh.admin.vo.wms.GoodsSkuInfo;
import com.hmsh.admin.wms.dao.GoodsSkuInfoDao;
@Service
public class GoodsSkuInfoServiceImpl extends BaseService<GoodsSkuInfo , Long> implements GoodsSkuInfoFacadeService{
	@Resource
	private GoodsSkuInfoDao goodsSkuInfoDao;

	@Override
	public BaseDao<GoodsSkuInfo, Long> getDao() {
		return goodsSkuInfoDao;
	}
}
