package com.hmsh.app.vo.rule;

import java.util.InputMismatchException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 服务费用分红表
 * Created by java on 2016/12/30.
 */
@Document(collection = "service_fee_bonus")
public class ServiceFeeBonus extends BaseEntity<Long>{
	private static final long serialVersionUID = 2336070920862636581L;
	private Long dmId;
    //名称描述
    private String name;
    //常量键值
    private String key;
    
    private Integer state;
    
    //分红比
    private Double bonusRatio;

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

    public Double getBonusRatio() {
        return bonusRatio;
    }

    public void setBonusRatio(Double bonusRatio) {
        this.bonusRatio = bonusRatio;
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
