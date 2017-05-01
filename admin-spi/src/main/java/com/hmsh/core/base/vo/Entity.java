package com.hmsh.core.base.vo;

public interface Entity<PK extends java.io.Serializable> extends java.io.Serializable{
	
	void setId(PK id);
	
	PK getId();
}
