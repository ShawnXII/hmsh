package com.hmsh.admin.wms.dao;

import java.util.List;

import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.exception.DaoException;
import com.hmsh.admin.vo.wms.GoodsPhotoInfo;



public interface GoodsPhotoInfoDao extends BaseDao<GoodsPhotoInfo, java.lang.Long>{
	/**
	 * 查询发货单商品信息图片
	 * @param skuId 
	 * @return
	 * @throws DaoException
	 */
	public List<GoodsPhotoInfo> findOnePhoto(String skuId)throws DaoException ;
	/**
	 * 查询发货单商品信息图片
	 * @param skuId 
	 * @return
	 * @throws DaoException
	 */
	public List<GoodsPhotoInfo> findGoodsPhoto(String skuId)throws DaoException ;
}
