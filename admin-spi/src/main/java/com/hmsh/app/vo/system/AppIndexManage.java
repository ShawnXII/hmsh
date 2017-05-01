package com.hmsh.app.vo.system;

import java.util.InputMismatchException;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:IndexManage
 * <br>Description:(首页配置VO实体类)
 * <br>Copyright: Copyright © 2017
 * <br>Company: 深圳市阿凡达互联网技术开发有限公司
 * @author Tom Tang
 * @version v1.0 2017-01-04
 */
public class AppIndexManage extends BaseEntity<Long> {

    /**(序列化UID)*/
    private static final long serialVersionUID = -8276412836566839907L;
    
	//
	private Long dmId;
	//图片地址
	private String imgUrl;
	//客户端跳转方式  字符串 
	private String skipMethod;
	//排序
	private Integer sort;
	//插入时间
	private Long crtime;
	//名字
	private String name;
	//版本类型（根据用户类型定义）商家版本（个人版本）
	private Integer versionType;
	//分类id
	private Long categoryId;
	//状态 0 启用 1关闭
	private Integer status;
	//是否开放 0 开放 1 关闭 
	private Integer isOpen;
	//备注
	private String notes;
	//
	private Integer isCenter;
	//
	private Long storeId;
	
	public AppIndexManage(){
		super();
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
    public String getImgUrl(){
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
    public String getSkipMethod(){
        return this.skipMethod;
    }
    public void setSkipMethod(String skipMethod){
        this.skipMethod = skipMethod;
    }
    public Integer getSort(){
        return this.sort;
    }
    public void setSort(Integer sort){
        this.sort = sort;
    }
    public Long getCrtime(){
        return this.crtime;
    }
    public void setCrtime(Long crtime){
        this.crtime = crtime;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getVersionType(){
        return this.versionType;
    }
    public void setVersionType(Integer versionType){
        this.versionType = versionType;
    }
    public Long getCategoryId(){
        return this.categoryId;
    }
    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }
    public Integer getStatus(){
        return this.status;
    }
    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getIsOpen(){
        return this.isOpen;
    }
    public void setIsOpen(Integer isOpen){
        this.isOpen = isOpen;
    }
    public String getNotes(){
        return this.notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public Integer getIsCenter(){
        return this.isCenter;
    }
    public void setIsCenter(Integer isCenter){
        this.isCenter = isCenter;
    }
    public Long getStoreId(){
        return this.storeId;
    }
    public void setStoreId(Long storeId){
        this.storeId = storeId;
    }
}
