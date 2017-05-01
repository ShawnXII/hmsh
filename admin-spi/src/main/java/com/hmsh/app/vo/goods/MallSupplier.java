package com.hmsh.app.vo.goods;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:MallSupplier
 * <br>Description:
 * <br>Copyright: Copyright © 2017
 * <br>Company: 深圳市阿凡达互联网技术开发有限公司
 * @author Tom Tang
 * @version v1.0 2017-02-18
 */
public class MallSupplier extends BaseEntity<Long> {

    /**(序列化UID)*/
    private static final long serialVersionUID = -1373468369224904775L;
    
	//
	private Long dmId;
	//
	private String name;
	//
	private String password;
	//
	private String phoneNum;
	//
	private String address;
	
	public MallSupplier(){
		super();
	}
	
    public Long getDmId(){
        return this.dmId;
    }
    public void setDmId(Long dmId){
        this.dmId = dmId;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    @Override
	public Long getId() {
		return this.dmId;
	}

	@Override
	public void setId(Long id) {
		this.dmId=id;
	}
    @Override
    public String toString() {
        return "MallSupplier[" +
        "dmId=" + dmId +
        ",name=" + name +
        ",password=" + password +
        ",phoneNum=" + phoneNum +
        ",address=" + address +
        ']';
    }

}
