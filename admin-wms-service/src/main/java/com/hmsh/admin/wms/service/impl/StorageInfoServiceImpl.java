package com.hmsh.admin.wms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.BaseService;
import com.hmsh.admin.service.wms.StorageInfoFacadeService;
import com.hmsh.admin.vo.wms.StorageInfo;
import com.hmsh.admin.wms.dao.StorageInfoDao;
@Service
public class StorageInfoServiceImpl extends BaseService<StorageInfo , Long> implements StorageInfoFacadeService{

	@Resource
	private StorageInfoDao storageInfoDao;

	@Override
	public BaseDao<StorageInfo, Long> getDao() {
		return storageInfoDao;
	}

}
