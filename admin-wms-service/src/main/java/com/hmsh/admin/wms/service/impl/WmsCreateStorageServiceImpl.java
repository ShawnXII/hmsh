package com.hmsh.admin.wms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.hmsh.admin.core.BaseDao;
import com.hmsh.admin.core.BaseService;
import com.hmsh.admin.core.exception.ServiceException;
import com.hmsh.admin.core.util.model.wms.GoodsSkuInfoModel;
import com.hmsh.admin.core.util.model.wms.StorageModel;
import com.hmsh.admin.service.wms.WmsCreateStorageFacadeService;
import com.hmsh.admin.wms.dao.StorageModelDao;
@Service
public class WmsCreateStorageServiceImpl extends BaseService<StorageModel , Long> implements WmsCreateStorageFacadeService{
    
	@Resource
	private StorageModelDao storageModelDao;

	@Override
	public BaseDao<StorageModel, Long> getDao() {
		return storageModelDao;
	}
	@Override
	public StorageModel queryStorage(Long storageNo) throws ServiceException {
		try {
			return storageModelDao.queryStorage(storageNo);
		} catch (Exception e) {
			log.error("查询失败", e);
			throw new ServiceException(e);
		}
	}
	@Override
	public String getStorageList(String storageNo, String customerNo) throws ServiceException {
		try {
			StorageModel storageModel=new StorageModel();
			storageModel.setCustomerNo(Long.valueOf(customerNo));
			storageModel.setStorageNo(Long.valueOf(storageNo));
			StorageModel retStorageModel = storageModelDao.findOneStorage(storageModel);
			return JSON.toJSONString(retStorageModel,new SerializeConfig()); 
		} catch (Exception e) {
			log.error("查询发货单信息失败", e);
			throw new ServiceException(e);
		}
	}
	@Override
	public String getGoodsList(String goodsId) throws ServiceException {
		try {
			String[] goodsIds=goodsId.split(",");
			List<GoodsSkuInfoModel> goodsSkuInfoModels=storageModelDao.queryStorageGoodsSku(goodsIds);
			return JSON.toJSONString(goodsSkuInfoModels,new SerializeConfig()); 
		} catch (Exception e) {
			log.error("查询发货单商品信息失败", e);
			throw new ServiceException(e);
		}
	}
}
