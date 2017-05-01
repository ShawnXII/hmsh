package com.hmsh.app.vo.rule;

import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 推荐人消费额分红表 Created by java on 2016/12/30.
 */
@Document(collection = "consumption_recommend_bonus")
public class ConsumptionRecommendBonus extends BaseEntity<Long> {

	private static final long serialVersionUID = -6027684848313392409L;

	private Long dmId;
	// 名称描述
	private String name;
	// 常量键值
	private String key;
	// 普通会员分红比例 此处记录的是*100后的值，计算时记得/100
	private Double memberBonusRatio;
	// 普通会员分红级数 -1表示无限级
	private Integer memberBonusSeries;
	// 合伙人分红比例 此处记录的是*100后的值，计算时记得/100
	private Double partnerBonusRatio;
	// 合伙人分红级数 -1表示无限级 -2表示所属区域
	private Integer partnerBonusSeries;
	// 代理分红比例 此处记录的是*100后的值，计算时记得/100
	private Double agentBonusRatio;
	// 代理分红级数 -1表示无限级 -2表示所属区域
	private Integer agentBonusSeries;
	// 状态 0:启用 1:禁用
	private Integer state;

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Double getMemberBonusRatio() {
		return memberBonusRatio;
	}

	public void setMemberBonusRatio(Double memberBonusRatio) {
		this.memberBonusRatio = memberBonusRatio;
	}

	public Integer getMemberBonusSeries() {
		return memberBonusSeries;
	}

	public void setMemberBonusSeries(Integer memberBonusSeries) {
		this.memberBonusSeries = memberBonusSeries;
	}

	public Double getPartnerBonusRatio() {
		return partnerBonusRatio;
	}

	public void setPartnerBonusRatio(Double partnerBonusRatio) {
		this.partnerBonusRatio = partnerBonusRatio;
	}

	public Integer getPartnerBonusSeries() {
		return partnerBonusSeries;
	}

	public void setPartnerBonusSeries(Integer partnerBonusSeries) {
		this.partnerBonusSeries = partnerBonusSeries;
	}

	public Double getAgentBonusRatio() {
		return agentBonusRatio;
	}

	public void setAgentBonusRatio(Double agentBonusRatio) {
		this.agentBonusRatio = agentBonusRatio;
	}

	public Integer getAgentBonusSeries() {
		return agentBonusSeries;
	}

	public void setAgentBonusSeries(Integer agentBonusSeries) {
		this.agentBonusSeries = agentBonusSeries;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
