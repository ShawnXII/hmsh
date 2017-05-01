package com.hmsh.admin.wms.dao;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.exception.DaoException;
import com.hmsh.admin.vo.wms.Storage;

public interface StorageDao extends BaseDao<Storage, java.lang.Long>{
	/**
	 * 查询发货单信息
	 * @param storageNo
	 * @return
	 * @throws DaoException
	 */
	Storage findOneStorage(Long storageNo)throws DaoException ;
}
