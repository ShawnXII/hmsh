package com.hmsh.app.vo.rule;

import java.util.InputMismatchException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 加盟费用表
 * Created by java on 2016/12/30.
 */
@Document(collection = "joining_fee")
public class JoiningFee extends BaseEntity<Long>{
	private static final long serialVersionUID = 3355138193260963772L;
	private Long dmId;
    //名称描述
    private String name;
    //常量键值
    private String key;
    //全额费用
    private Double fullCost;
    //诚意金
    private Double earnestMoney;
    //收益扣除比例 此处记录的是*100后的值，计算时记得/100
    private Double deductionRatio;
    //状态 0:启用 1:禁用
    private Integer state;

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

    public Double getFullCost() {
        return fullCost;
    }

    public void setFullCost(Double fullCost) {
        this.fullCost = fullCost;
    }

    public Double getEarnestMoney() {
        return earnestMoney;
    }

    public void setEarnestMoney(Double earnestMoney) {
        this.earnestMoney = earnestMoney;
    }

    public Double getDeductionRatio() {
        return deductionRatio;
    }

    public void setDeductionRatio(Double deductionRatio) {
        this.deductionRatio = deductionRatio;
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
