package com.hmsh.admin.wms.dao;

import java.util.List;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.exception.DaoException;
import com.hmsh.admin.vo.wms.GoodsRepertoryNum;



public interface GoodsRepertoryNumDao extends BaseDao<GoodsRepertoryNum, java.lang.Long>{
	/**
	 * 获取sku的库存
	 * @param skuId
	 * @return
	 * @throws DaoException
	 */
	public List<GoodsRepertoryNum> findOneNum(String skuId)throws DaoException ;
}
