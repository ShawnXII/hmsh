package com.hmsh.app.vo.goods;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;

/**
 * @author wangxiang
 * @date 2017-05-01 21:09:53
 * @version 1.0.0
 */
@Table(name = "novel_goods_details")
public class GoodsDetails implements Serializable {
	// 主键; 商品ID
	@Id
	private Long goodsid;

	// 详情内容
	@NotEmpty(message = "context不能为空!")
	private String context;

	private static final long serialVersionUID = 1L;

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}