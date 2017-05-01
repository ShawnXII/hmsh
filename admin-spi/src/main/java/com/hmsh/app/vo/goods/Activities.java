package com.hmsh.app.vo.goods;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * Title:Activities
 * <br>Description:()
 * <br>Copyright: Copyright © 2017
 * <br>Company: 深圳市阿凡达互联网技术开发有限公司
 * @author Tom Tang
 * @version v1.0 2017-02-14
 */
public class Activities extends BaseEntity<Long> {

    /**(序列化UID)*/
    private static final long serialVersionUID = -4506384470192208418L;
    
	//主键
	private Long dmId;
	//专区标题
	private String title;
	//排序号
	private Integer sequence;
	//创建时间
	private Long createTime;
	//有效时间（0永久）
	private Long termOfValidity;
	//开始时间
	private Long startTime;
	//图标
	private String icon;
	//状态(0:正常 1:隐藏 )
	private Integer state;
	//模块
	private String module;
	
	public Activities(){
		super();
	}
	
    public Long getDmId(){
        return this.dmId;
    }
    public void setDmId(Long dmId){
        this.dmId = dmId;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public Integer getSequence(){
        return this.sequence;
    }
    public void setSequence(Integer sequence){
        this.sequence = sequence;
    }
    public Long getCreateTime(){
        return this.createTime;
    }
    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }
    public Long getTermOfValidity(){
        return this.termOfValidity;
    }
    public void setTermOfValidity(Long termOfValidity){
        this.termOfValidity = termOfValidity;
    }
    public Long getStartTime(){
        return this.startTime;
    }
    public void setStartTime(Long startTime){
        this.startTime = startTime;
    }
    public String getIcon(){
        return this.icon;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public Integer getState(){
        return this.state;
    }
    public void setState(Integer state){
        this.state = state;
    }
    public String getModule(){
        return this.module;
    }
    public void setModule(String module){
        this.module = module;
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
        return "Activities[" +
        "dmId=" + dmId +
        ",title=" + title +
        ",sequence=" + sequence +
        ",createTime=" + createTime +
        ",termOfValidity=" + termOfValidity +
        ",startTime=" + startTime +
        ",icon=" + icon +
        ",state=" + state +
        ",module=" + module +
        ']';
    }

}
