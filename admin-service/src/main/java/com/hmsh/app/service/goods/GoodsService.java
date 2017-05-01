package com.hmsh.app.service.goods;

import org.springframework.stereotype.Service;

import com.hmsh.app.dao.goods.GoodsDao;
import com.hmsh.app.service.facade.goods.GoodsFacadeService;
import com.hmsh.app.vo.goods.Goods;
import com.hmsh.core.exception.ServiceException;
/**
 * 商品管理
 * @author ShawnXII
 *
 */
@Service
public class GoodsService  implements GoodsFacadeService {
	
	private GoodsDao goodsDao;

	
	//@Override
	public Goods add(Goods goods) throws ServiceException {
		/*try {
			if(goods.getId()==null){
				Long id = Commutil.generateId();
				goods.setId(id);
			}
			goods.setDefault();
			ValidationResult result=ValidationUtils.validateEntity(goods);
			if(result.isHasErrors()){
				throw new Exception(result.getErrorMsg().toString());
			}
			List<GoodsPhoto> goodsPhotoList=new ArrayList<>();
			List<GoodsDetails> goodsDetailsList=new ArrayList<>();
			List<ShopGoodsSku> shopList=new ArrayList<>();
			if(goods.getGoodsSkuList()!=null&&goods.getGoodsSkuList().size()>0){
				for(GoodsSku sku:goods.getGoodsSkuList()){
					sku.setGoodsId(goods.getDmId());
					if(sku.getDmId()==null){
						sku.setDmId(Commutil.generateId());						
					}
					List<GoodsPhoto> photoList=sku.getPhotoList();
					if(photoList!=null&&photoList.size()>0){
						int i=1;
						for(GoodsPhoto photo:photoList){
							photo.setGoodsSkuId(sku.getDmId());
							if(photo.getType()==null){
								photo.setType(0);
							}
							if(photo.getSequence()==null){
								photo.setSequence(i);
								i+=10;
							}
							if(StringUtils.isNotBlank(photo.getPath())){
								goodsPhotoList.add(photo);
							}	
						}
					}
					List<GoodsDetails> detailsList=sku.getGoodsDetailsList();
					if(detailsList!=null&&detailsList.size()>0){
						for(GoodsDetails details:detailsList){
							details.setGoodsId(sku.getDmId());
							if(StringUtils.isNotBlank(details.getContext())){
								goodsDetailsList.add(details);
							}
						}
					}
					ShopGoodsSku shop = sku.getShopGoodsSku();
					if(shop!=null){
						shop.setDmId(Commutil.generateId());
						shop.setGoodsSkuId(sku.getDmId());
						shopList.add(shop);
					}					
				}
			}
			goods.setGoodsDetailsList(goodsDetailsList);
			goods.setShopList(shopList);
			goods.setPhotoList(goodsPhotoList);
			this.goodsDao.insert(goods);
			return goods;
		} catch (Exception e) {
			throw new ServiceException(e);
		}*/
		return null;
	}
	
	
}
