package com.hmsh.core.base.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.hmsh.core.base.vo.Entity;

public interface BaseMapper<T extends Entity<PK>, PK extends Serializable> extends Mapper<T> {

	@InsertProvider(method = "insert", type = SqlProvider.class)
	public int insert(T bean) ;

	@InsertProvider(method = "insertList", type = SqlProvider.class)
	public int insertList(List<T> list);

	@UpdateProvider(type = SqlProvider.class, method = "update")
	public int update(T bean);

	@UpdateProvider(type = SqlProvider.class, method = "updateNotNull")
	public int updateNotNull(T bean);

	@DeleteProvider(type = SqlProvider.class, method = "remove")
	public int remove(T bean);

	@SelectProvider(type = SqlProvider.class, method = "find")
	@ResultMap(value="BaseResultMap")
	public List<T> find(T bean);
	
	@SelectProvider(type = SqlProvider.class, method = "find")
	public List<T> query(Example example);
}
