package com.hmsh.app.vo.rule;

import java.util.InputMismatchException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 服务费用表
 * Created by java on 2016/12/30.
 */
@Document(collection = "service_fee")
public class ServiceFee extends BaseEntity<Long>{
	private static final long serialVersionUID = -2725278546929463375L;
	private Long dmId;
    //名称描述
    private String name;
    //常量键值
    private String key;
    //服务费用
    private Double fee;
    //返积分 -1 代表不返
    private Integer returnPoints;
    //整数月 -1代表无限
    private Double servicePeriod;
    
    private Integer state;

    public ServiceFee() {
    }

    public ServiceFee(String key) {
        this.key = key;
    }

    public ServiceFee(String name, String key, Double fee, Integer returnPoints, Double servicePeriod) {
        this.name = name;
        this.key = key;
        this.fee = fee;
        this.returnPoints = returnPoints;
        this.servicePeriod = servicePeriod;
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

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getReturnPoints() {
        return returnPoints;
    }

    public void setReturnPoints(Integer returnPoints) {
        this.returnPoints = returnPoints;
    }

    public Double getServicePeriod() {
        return servicePeriod;
    }

    public void setServicePeriod(Double servicePeriod) {
        this.servicePeriod = servicePeriod;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
