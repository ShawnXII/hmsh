package com.hmsh.core.base;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hmsh.core.base.vo.BaseEntity;
import com.hmsh.core.exception.DaoException;
import com.hmsh.core.tool.EntityUtils;
import com.hmsh.core.tool.QueryTool;
import com.mongodb.WriteResult;

/**
 * Mongo 的BaseDao 添加分页方法 单表操作
 * 
 * @author ShawnXII
 *
 * @param <T>
 * @param <PK>
 */
public abstract class MongDbDaoImpl<T extends BaseEntity<PK>, PK extends Serializable> implements BaseDao<T, PK> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1150383767481747587L;

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final String entityId = "dmId";

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = (Class<T>) EntityUtils.getEntityClass(this.getClass());

	@Override
	public int insert(T entity) throws DaoException {
		try {
			mongoTemplate.insert(entity);
			return 1;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public int update(T entity) throws Exception {
		return update(entity,true);
	}

	@Override
	public int updateNotNull(T entity) throws Exception {
		return update(entity,false);
	}
	
	private int  update(T entity,boolean isNotNull) throws Exception{
		if (entity.getId() == null) {
			throw new Exception("缺少主键!");
		}
		Criteria criteria = Criteria.where(entityId).is(entity.getId());
		Query query = new Query();
		query.addCriteria(criteria);
		try {
			Update update =QueryTool.bean2Update(entity,isNotNull);
			if (update.getUpdateObject().toMap().size() <= 0) {
				throw new Exception("实体转换异常,没有数据!");
			}
			WriteResult updateMulti = mongoTemplate.updateFirst(query, update, entity.getClass());
			return updateMulti.getN();
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new Exception(e);
		}
	}

	@Override
	public int insertList(List<T> collection) throws Exception {
		mongoTemplate.insertAll(collection);
		return collection.size();	
	}

	@Override
	public T findOne(PK pk) throws Exception {
		Query query = new Query(Criteria.where(entityId).is(pk));
		return mongoTemplate.findOne(query, entityClass);
	}

	@Override
	public List<T> findAll(T entity) throws Exception {
		try {
			Query query = QueryTool.bean2Where(entity,false);
			return mongoTemplate.find(query, entityClass);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new Exception(e);
		}
	}

	@Override
	public long count(T entity) throws Exception {
		try {
			Query query = QueryTool.bean2Where(entity);
			return mongoTemplate.count(query, entityClass);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new Exception(e);
		}
	}

	@Override
	public int removeList(List<PK> list) throws Exception {
		Criteria criteria = Criteria.where(entityId).in(list);
		Query query = new Query();
		query.addCriteria(criteria);
		WriteResult result = mongoTemplate.remove(query, entityClass);
		return result.getN();
	}

	@Override
	public int remove(PK pk) throws Exception {
		Criteria criteria = Criteria.where(entityId).is(pk);
		Query query = new Query();
		query.addCriteria(criteria);
		WriteResult result = mongoTemplate.remove(query, entityClass);
		return result.getN();
	}
	
	public Page<T> query(T entity) throws Exception{
		/*Integer start=entity.getStart();
		Integer length=entity.getLength();*/
		/*Integer index=start/length;
		Pageable page=new PageRequest(index,length);
		Query query=QueryTool.bean2Where(entity);
		Long count = this.mongoTemplate.count(query, entityClass);
		if(count>0){
			List<T> list = mongoTemplate.find(query, entityClass);
			return  new PageImpl<T>(list, page, count);
		}*/
		//return new PageImpl<T>(new ArrayList<T>(), page, count);
		return null;
	}	
}
