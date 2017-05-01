package com.hmsh.app.vo.goods;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * @author wangxiang 
 * @date 2017-05-01 21:06:56
 * @version 1.0.0
 */
@Table(name="novel_goods_specproperty")
public class GoodsSpecproperty extends BaseEntity<Long> {
    // 主键; 
    @Id
    private Long dmid;

    // 
    @NotEmpty(message="value不能为空!")
    private String value;

    // 序号 越小越靠前
    private Integer sequence;

    // 值类型 0:文字(默认) 1:图片
    private String type;

    // 属性ID
    @NotEmpty(message="goodsSpecificationId不能为空!")
    private Long goodsspecificationid;

    // 创建人
    private String createby;

    // 创建时间
    private Long createtime;

    // 最后一次更新人
    private String updateby;

    // 更新时间
    private Long updatetime;

    // 
    private String image;

    private static final long serialVersionUID = 1L;

    public Long getDmid() {
        return dmid;
    }

    public void setDmid(Long dmid) {
        this.dmid = dmid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getGoodsspecificationid() {
        return goodsspecificationid;
    }

    public void setGoodsspecificationid(Long goodsspecificationid) {
        this.goodsspecificationid = goodsspecificationid;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

	@Override
	public void setId(Long id) {
		this.setDmid(id);
	}

	@Override
	public Long getId() {
		return this.getDmid();
	}
}