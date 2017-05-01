package com.hmsh.app.vo.system;

import java.util.InputMismatchException;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

@Document(collection ="share_message")
public class ShareMessage extends BaseEntity<Long>{
	private static final long serialVersionUID = -20338714410513336L;
	private Long dmId ;	
	/*
	 * 标题
	 */
	private String title;
	/*
	 * 详细
	 */
	private String context;
	/*
	 * url 地址
	 */
	private String url;
	/*
	 * 图片地址
	 */
	private String img;
	/*
	 * 状态  0 正常  1 屏蔽
	 */
	private Integer status;
	/*
	 * 分类   0 用户分享     1 活动分享      20优惠券分享  21 霸王券分享  22 折扣券分享   23 礼品券
	 */
	private Integer stype;
	/*
	 * 第三方ID
	 */
	private String threeId;
	/*
	 * 创建时间
	 */
	private Long crtime;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStype() {
		return stype;
	}
	public void setStype(Integer stype) {
		this.stype = stype;
	}
	public String getThreeId() {
		return threeId;
	}
	public void setThreeId(String threeId) {
		this.threeId = threeId;
	}
	public Long getCrtime() {
		return crtime;
	}
	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}
	@Override
	public void setId(Long id) throws InputMismatchException {
		this.dmId = id;
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
}
