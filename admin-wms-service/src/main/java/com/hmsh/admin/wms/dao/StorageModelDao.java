package com.hmsh.admin.wms.dao;

import java.util.List;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.exception.DaoException;
import com.hmsh.admin.core.util.model.wms.GoodsSkuInfoModel;
import com.hmsh.admin.core.util.model.wms.StorageModel;



public interface StorageModelDao extends BaseDao<StorageModel, java.lang.Long>{
	/**
	 * 查询发货单信息
	 * @param storageNo
	 * @return
	 * @throws DaoException
	 */
	public StorageModel queryStorage(Long storageNo)throws DaoException ;
	
	/**
	 * 查询发货单信息
	 * @param storageModel
	 * @return
	 * @throws DaoException
	 */
	public StorageModel findOneStorage(StorageModel storageModel)throws DaoException ;
	
	/**
	 * 查询发货单商品信息
	 * @param skuId skuId ','分隔
	 * @return
	 * @throws DaoException
	 */
	public List<GoodsSkuInfoModel> queryStorageGoodsSku(String[] skuId)throws DaoException ;
}
