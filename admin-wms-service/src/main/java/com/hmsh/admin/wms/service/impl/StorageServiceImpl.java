package com.hmsh.admin.wms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.BaseService;
import com.hmsh.admin.core.exception.ServiceException;
import com.hmsh.admin.service.wms.StorageFacadeService;
import com.hmsh.admin.vo.wms.Storage;
import com.hmsh.admin.wms.dao.StorageDao;
@Service
public class StorageServiceImpl extends BaseService<Storage , Long> implements StorageFacadeService{

	@Resource
	private StorageDao storageDao;

	@Override
	public BaseDao<Storage, Long> getDao() {
		return storageDao;
	}

	@Override
	public Storage findOneStorage(Long storageNo) throws ServiceException {
		try {
			return storageDao.findOneStorage(storageNo);
		} catch (Exception e) {
			log.error("查询失败", e);
			throw new ServiceException(e);
		}
	}
    

}
