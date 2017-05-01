package com.hmsh.app.vo.wms;

import com.hmsh.core.base.vo.BaseEntity;
/**
 * 商品图片信息
 * @author leichao
 *
 */
public class GoodsPhotoInfo extends BaseEntity<Long> {

	private static final long serialVersionUID = 246077509030075554L;
	
	private Long id;
    /**
     * 商品ID
     */
	private Long skuID;	
	/**
	 * 图片
	 */
	private String path;
	/**
	 * 类型
	 */
	private int type;
	/**
	 * 排序
	 */
	private Long sequence;
	
	private String context;
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Long getSkuID() {
		return skuID;
	}
	public void setSkuID(Long skuID) {
		this.skuID = skuID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
