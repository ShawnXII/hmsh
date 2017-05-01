package com.hmsh.app.vo.goods;

import java.util.InputMismatchException;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;


@Document(collection = "goods_class")
public class GoodsClass extends BaseEntity<Long> implements Comparable<GoodsClass>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2166218319716880556L;
	@Indexed
	private Long dmId;
	@Indexed
	private String title;

	@Indexed
	private String pinyin;

	// 图片
	private String image;

	// 链接
	private String url;

	// 状态 0:正常 1:禁用
	private Integer state;

	// 上级ID
	private Long parentId;

	@Transient
	private GoodsClass parent;

	// 跳转方式
	private String target;

	// 等级
	private Integer level;

	// 排序号
	private Integer sequence;

	// 备注
	private String remarks;
	// 创建时间
	private Long createTime;
	// 创建人
	private String createBy;
	// 最后修改时间
	private Long updateTime;
	// 最后修改人
	private String updateBy;
	
	//0在自营商城展示,1不展示
	private Integer selfMall;
	//0在积分商城展示,1不展示
	private Integer pointsMall;
	
	/*------------------------------非数据库字段--------------------------------------------*/
	// 是否选中标识
	@Transient
	private String flag;
	
	@Transient
	private List<GoodsClass> childs;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public List<GoodsClass> getChilds() {
		return childs;
	}

	public void setChilds(List<GoodsClass> childs) {
		this.childs = childs;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public GoodsClass getParent() {
		return parent;
	}

	public void setParent(GoodsClass parent) {
		this.parent = parent;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public void setId(Long id) throws InputMismatchException {
		this.dmId=id;
	}

	@Override
	public Long getId() {		
		return this.dmId;
	}

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	@Override
	public int compareTo(GoodsClass o) {
		return o.sequence.compareTo(this.sequence);
	}

	public Integer getSelfMall() {
		return selfMall;
	}

	public void setSelfMall(Integer selfMall) {
		this.selfMall = selfMall;
	}

	public Integer getPointsMall() {
		return pointsMall;
	}

	public void setPointsMall(Integer pointsMall) {
		this.pointsMall = pointsMall;
	}	
}
