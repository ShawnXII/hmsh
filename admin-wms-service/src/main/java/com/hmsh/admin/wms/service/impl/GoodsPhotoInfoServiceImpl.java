package com.hmsh.admin.wms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.BaseService;
import com.hmsh.admin.service.wms.GoodsPhotoInfoFacadeService;
import com.hmsh.admin.vo.wms.GoodsPhotoInfo;
import com.hmsh.admin.wms.dao.GoodsPhotoInfoDao;
@Service
public class GoodsPhotoInfoServiceImpl extends BaseService<GoodsPhotoInfo , Long> implements GoodsPhotoInfoFacadeService{

	@Resource
	private GoodsPhotoInfoDao goodsPhotoInfoDao;

	@Override
	public BaseDao<GoodsPhotoInfo, Long> getDao() {
		return goodsPhotoInfoDao;
	}
	

}
