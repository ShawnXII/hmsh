package com.hmsh.app.vo.rule;

import java.util.InputMismatchException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 卖家扣点表 Created by java on 2016/12/30.
 */
@Document(collection = "sellers_points")
public class SellersPoints extends BaseEntity<Long> {
	private static final long serialVersionUID = 4671211787341779588L;
	private Long dmId;
	// 名称描述
	private String name;
	// 扣点比例 此处记录的是*100后的值，计算时记得/100
	private Double points;
	// 用户购买返积分比例 此处记录的是*100后的值，计算时记得/100
	private Double returnPoints;
	// 区域代理商分润比例 此处记录的是*100后的值，计算时记得/100
	private Double agentProfit;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Double getReturnPoints() {
		return returnPoints;
	}

	public void setReturnPoints(Double returnPoints) {
		this.returnPoints = returnPoints;
	}

	public Double getAgentProfit() {
		return agentProfit;
	}

	public void setAgentProfit(Double agentProfit) {
		this.agentProfit = agentProfit;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
