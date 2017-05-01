package com.hmsh.app.vo.system;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

@Document(collection = "sys_configur")
public class AdvertisManage extends BaseEntity<Long> {

	private static final long serialVersionUID = 8297217539060714674L;
	private Long dmId;
	/** 上级 */
	private Long parentId;
	/** key 名字 */
	private String name;
	/** key值 */
	private String keyName;
	/** value值 */
	private String keyValue;
	/** 更改员工 */
	private Long userId;
	/** 更改时间 */
	private Long uptime;
	/** 层级 */
	private Integer level;
	/** 数据类型 0：文字；1：图片 */
	private Integer dataType;

	private List<AdvertisManage> childList;

	/** 新版后台使用 用户归类后的跳转 **/
	private String targetUrl;
	/** 1 android 2 IOs **/
	private Integer clientType;

	/** 后台用 数据的分组 **/
	private String groupKey;
	private String groupName;
	/** 排序 */
	private Integer order;
	/** 状态 0 正常 1 禁用 */
	private Integer status;

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyValue() {
		return this.keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUptime() {
		return this.uptime;
	}

	public void setUptime(Long uptime) {
		this.uptime = uptime;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<AdvertisManage> getChildList() {
		return childList;
	}

	public void setChildList(List<AdvertisManage> childList) {
		this.childList = childList;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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