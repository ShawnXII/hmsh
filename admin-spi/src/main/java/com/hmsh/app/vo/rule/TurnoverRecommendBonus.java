package com.hmsh.app.vo.rule;

import java.util.InputMismatchException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hmsh.core.base.vo.BaseEntity;

/**
 * 推荐人营业额分红表
 * Created by java on 2016/12/30.
 */
@Document(collection = "turnover_recommend_bonus")
public class TurnoverRecommendBonus extends BaseEntity<Long>{
	
	private static final long serialVersionUID = 7083906851779027418L;
	
	private Long dmId;
    //名称描述
    private String name;
    //常量键值
    private String key;
    //分红比例  此处记录的是*100后的值，计算时记得/100
    private Double bonusRatio;
    //分红级数 -1表示无限级
    private Integer bonusSeries;
    
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

    public Double getBonusRatio() {
        return bonusRatio;
    }

    public void setBonusRatio(Double bonusRatio) {
        this.bonusRatio = bonusRatio;
    }

    public Integer getBonusSeries() {
        return bonusSeries;
    }

    public void setBonusSeries(Integer bonusSeries) {
        this.bonusSeries = bonusSeries;
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
