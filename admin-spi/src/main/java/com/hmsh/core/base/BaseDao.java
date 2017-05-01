package com.hmsh.core.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends Serializable, PK extends Serializable> extends java.io.Serializable {
	/**
	 * 插入
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int insert(T entity) throws Exception;
	/**
	 * 修改 根据主键
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(T entity) throws Exception;
	/**
	 * 修改不为null的字段 根据主键
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int updateNotNull(T entity) throws Exception;
	/**
	 * 插入多条 
	 * @param collection
	 * @return
	 * @throws Exception
	 */
	int insertList(List<T> collection)throws Exception;
	/**
	 * 根据主键查询
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	T findOne(PK pk)throws Exception;
	/**
	 * 查询总条数
	 * @param entity
	 * @return
	 */
	List<T> findAll(T entity)throws Exception;
	/**
	 * 查询总条数
	 * @param entity
	 * @return
	 */
	long count(T entity)throws Exception;
	/**
	 * 根据主键删除
	 * @param pks
	 * @return
	 */
	int removeList(List<PK> ids)throws Exception;
	/**
	 * 根据主键删除
	 * @param pk
	 * @return
	 */
	int remove(PK pk)throws Exception;
}
