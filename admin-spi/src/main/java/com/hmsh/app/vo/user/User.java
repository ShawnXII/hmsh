package com.hmsh.app.vo.user;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 个人用户
 * 
 * @author ShawnXII
 *
 */
@Document(collection = "user")
public class User extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8094583680343573754L;

	private Long dmId;
	// 手机号
	private String mphonenum;
	// 登录账号
	private String account;
	// 昵称
	private String nickname;

	// 头像
	private String headimg;
	// 性别 0 女 1 男
	private String sex;
	// 保存当前用户登录时的平台 1 安卓 2 IOS
	private String platForm;
	// 动态背景设置
	private String dynamicBackground;
	// 出生日期
	private Long dob;
	// 所在公司
	private String theCompany;
	// 1 个人账户(默认) 2 商家账户
	private Integer userType;
	// 0 ：未认证 1 已认证
	private Integer authen;
	// 实名认证 0：未认证，1：已认证
	private Integer newAuthen;
	// 个性签名
	private String signat;
	// 联系方式
	private String contactWay;
	// 0 正常 1 屏蔽 2 注销
	private Integer status;
	// 禁用说明
	private String stopTxt;
	// 禁用时间
	private Long stopTime;
	// 注册时间
	private Long ctrime;
	// 用户邀请码
	private String vistCode;
	// 邀请人
	private String vistUserCode;
	// 推送Code值
	private String pushCode;
	// 毕业学校
	private String graduateSchool;
	// 步奏 0未开,1 注册, 2完善 3等待审核
	private Integer steps;
	// 用户注销原因
	private String cancelReason;
	// 历史手机号
	private String hisMphonenum;
	// 邀请人电话
	private String vistUserPhonenum;
	// 是否有商店 0- has 1-no
	private Integer isStore;
	// 注销时间
	private Long cancelTime;
	// 重置手机号码图片
	private String resetPhoneImg;
	// 重置手机号原因
	private String resetPhoneReason;
	// 处理状态 0 未处理 1处理成功
	private Integer blockedStatus;

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public String getMphonenum() {
		return mphonenum;
	}

	public void setMphonenum(String mphonenum) {
		this.mphonenum = mphonenum;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPlatForm() {
		return platForm;
	}

	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}

	public String getDynamicBackground() {
		return dynamicBackground;
	}

	public void setDynamicBackground(String dynamicBackground) {
		this.dynamicBackground = dynamicBackground;
	}

	public Long getDob() {
		return dob;
	}

	public void setDob(Long dob) {
		this.dob = dob;
	}

	public String getTheCompany() {
		return theCompany;
	}

	public void setTheCompany(String theCompany) {
		this.theCompany = theCompany;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getAuthen() {
		return authen;
	}

	public void setAuthen(Integer authen) {
		this.authen = authen;
	}

	public Integer getNewAuthen() {
		return newAuthen;
	}

	public void setNewAuthen(Integer newAuthen) {
		this.newAuthen = newAuthen;
	}

	public String getSignat() {
		return signat;
	}

	public void setSignat(String signat) {
		this.signat = signat;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStopTxt() {
		return stopTxt;
	}

	public void setStopTxt(String stopTxt) {
		this.stopTxt = stopTxt;
	}

	public Long getStopTime() {
		return stopTime;
	}

	public void setStopTime(Long stopTime) {
		this.stopTime = stopTime;
	}

	public Long getCtrime() {
		return ctrime;
	}

	public void setCtrime(Long ctrime) {
		this.ctrime = ctrime;
	}

	public String getVistCode() {
		return vistCode;
	}

	public void setVistCode(String vistCode) {
		this.vistCode = vistCode;
	}

	public String getVistUserCode() {
		return vistUserCode;
	}

	public void setVistUserCode(String vistUserCode) {
		this.vistUserCode = vistUserCode;
	}

	public String getPushCode() {
		return pushCode;
	}

	public void setPushCode(String pushCode) {
		this.pushCode = pushCode;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getHisMphonenum() {
		return hisMphonenum;
	}

	public void setHisMphonenum(String hisMphonenum) {
		this.hisMphonenum = hisMphonenum;
	}

	public String getVistUserPhonenum() {
		return vistUserPhonenum;
	}

	public void setVistUserPhonenum(String vistUserPhonenum) {
		this.vistUserPhonenum = vistUserPhonenum;
	}

	public Integer getIsStore() {
		return isStore;
	}

	public void setIsStore(Integer isStore) {
		this.isStore = isStore;
	}

	public Long getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Long cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getResetPhoneImg() {
		return resetPhoneImg;
	}

	public void setResetPhoneImg(String resetPhoneImg) {
		this.resetPhoneImg = resetPhoneImg;
	}

	public String getResetPhoneReason() {
		return resetPhoneReason;
	}

	public void setResetPhoneReason(String resetPhoneReason) {
		this.resetPhoneReason = resetPhoneReason;
	}

	public Integer getBlockedStatus() {
		return blockedStatus;
	}

	public void setBlockedStatus(Integer blockedStatus) {
		this.blockedStatus = blockedStatus;
	}

	@Override
	public Long getId() {
		return this.dmId;
	}

	@Override
	public void setId(Long id) {
		this.dmId=id;
	}

}
