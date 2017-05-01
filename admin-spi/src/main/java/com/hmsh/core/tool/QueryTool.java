package com.hmsh.core.tool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.alibaba.fastjson.JSON;
import com.hmsh.core.base.vo.Entity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Mongo Query工具类
 * 
 * 实体类需要遵守规则: 不能有基本类型
 * 
 * @author ShawnXII
 *
 */
public final class QueryTool {

	private static final Logger log = LoggerFactory.getLogger(QueryTool.class);

	private static final String[] ignore = { "start", "length", "orderBy", "isNewRecord", "serialVersionUID","paging"};

	/**
	 * 把实体bean对象转换成DBObject
	 * 
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <T extends Entity<PK>, PK extends java.io.Serializable> BasicDBObject bean2DBObject(T bean)
			throws IllegalArgumentException, IllegalAccessException {
		BasicDBObject dbObject = new BasicDBObject();
		if (bean == null) {
			return null;
		}

		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			// 获取属性名
			String varName = field.getName();
			boolean accessible = field.isAccessible();
			if (!accessible) {
				field.setAccessible(true);
			}
			Object param = field.get(bean);
			if (param == null || isIgnore(varName)) {
				continue;
			}
			if (param instanceof Integer) {// 判断变量的类型
				int value = ((Integer) param).intValue();
				dbObject.put(varName, value);
			} else if (param instanceof String) {
				String value = (String) param;
				dbObject.put(varName, value);
			} else if (param instanceof Double) {
				double value = ((Double) param).doubleValue();
				dbObject.put(varName, value);
			} else if (param instanceof Float) {
				float value = ((Float) param).floatValue();
				dbObject.put(varName, value);
			} else if (param instanceof Long) {
				long value = ((Long) param).longValue();
				dbObject.put(varName, value);
			} else if (param instanceof Boolean) {
				boolean value = ((Boolean) param).booleanValue();
				dbObject.put(varName, value);
			} else if (param instanceof Date) {
				Date value = (Date) param;
				dbObject.put(varName, value);
			} else if (param instanceof BigDecimal) {
				BigDecimal value = (BigDecimal) param;
				dbObject.put(varName, value);
			}
			// 恢复访问控制权限
			field.setAccessible(accessible);
		}

		return dbObject;
	}

	/**
	 * 把DBObject转换成bean对象
	 * 
	 * @param dbObject
	 * @param bean
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static <T extends Entity<PK>, PK extends java.io.Serializable> T dbObject2Bean(DBObject dbObject, T bean)
			throws IllegalAccessException, InvocationTargetException {
		if (bean == null) {
			return null;
		}
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			String varName = field.getName();
			Object object = dbObject.get(varName);
			if (object != null) {
				BeanUtils.setProperty(bean, varName, object);
			}
		}

		return bean;
	}
	
	public static <T extends Entity<PK>, PK extends java.io.Serializable> Update bean2Update(T bean)
			throws IllegalArgumentException, IllegalAccessException {
		return bean2Update(bean,true);
	}
	/**
	 * 对象转 Update对象
	 * 
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <T extends Entity<PK>, PK extends java.io.Serializable> Update bean2Update(T bean,boolean isNotNull)
			throws IllegalArgumentException, IllegalAccessException {
		Update update = new Update();
		Field[] declaredFields = bean.getClass().getDeclaredFields();
		Field[] superFields = bean.getClass().getSuperclass().getDeclaredFields();
		List<Field> fields = combination2List(declaredFields, superFields);
		if (fields != null && fields.size() > 0) {
			for (Field field : fields) {
				// 获取属性名
				String varName = field.getName();
				// 修改访问控制权限
				boolean accessFlag = field.isAccessible();
				if (!accessFlag) {
					field.setAccessible(true);
				}
				Object param = field.get(bean);
				if ( isIgnore(varName)) {
					continue;
				}
				if(isNotNull&&param == null){
					continue;
				}
				if (param instanceof Integer) {// 判断变量的类型
					int value = ((Integer) param).intValue();
					update.set(varName, value);
				} else if (param instanceof String) {
					String value = (String) param;
					update.set(varName, value);
				} else if (param instanceof Double) {
					double value = ((Double) param).doubleValue();
					update.set(varName, value);
				} else if (param instanceof Float) {
					float value = ((Float) param).floatValue();
					update.set(varName, value);
				} else if (param instanceof Long) {
					long value = ((Long) param).longValue();
					update.set(varName, value);
				} else if (param instanceof Boolean) {
					boolean value = ((Boolean) param).booleanValue();
					update.set(varName, value);
				} else if (param instanceof Date) {
					Date value = (Date) param;
					update.set(varName, value);
				} else if (param instanceof BigDecimal) {
					BigDecimal value = (BigDecimal) param;
					update.set(varName, value);
				} else {
					update.set(varName, JSON.parseObject(JSON.toJSONString(param), param.getClass()));
				}
				// 恢复访问控制权限
				field.setAccessible(accessFlag);
			}
		}
		return update;
	}
	
	/**
	 * bean 转换为查询条件
	 * 
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <T extends Entity<PK>, PK extends java.io.Serializable> Query bean2Where(T bean)
			throws IllegalArgumentException, IllegalAccessException {
		return bean2Where(bean, true);
	}

	/**
	 * bean 转换为查询条件
	 * 
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <T extends Entity<PK>, PK extends java.io.Serializable> Query bean2Where(T bean, boolean isPage)
			throws IllegalArgumentException, IllegalAccessException {
		Query query = new Query();
		Field[] declaredFields = bean.getClass().getDeclaredFields();
		Field[] superFields = bean.getClass().getSuperclass().getDeclaredFields();
		List<Field> fields = combination2List(declaredFields, superFields);
		Integer start = null, length = null;
		String order = null;
		if (fields != null && fields.size() > 0) {
			for (Field field : fields) {
				// 获取属性名
				String varName = field.getName();
				// 修改访问控制权限
				boolean accessFlag = field.isAccessible();
				if (!accessFlag) {
					field.setAccessible(true);
				}
				Object param = field.get(bean);
				if (param == null || isIgnore(varName)) {
					if ("start".equals(varName)) {
						if (param instanceof Integer) {
							start = ((Integer) param).intValue();
						}
					} else if ("length".equals(varName)) {
						if (param instanceof Integer) {
							length = ((Integer) param).intValue();
						}
					} else if ("orderBy".equals(varName)) {
						if (param instanceof String) {
							order = (String) param;
						}
					}
					continue;
				}
				if (param instanceof Integer) {// 判断变量的类型
					int value = ((Integer) param).intValue();
					query.addCriteria(Criteria.where(varName).is(value));
				} else if (param instanceof String) {
					String value = (String) param;
					query.addCriteria(Criteria.where(varName).is(value));
				} else if (param instanceof Double) {
					double value = ((Double) param).doubleValue();
					query.addCriteria(Criteria.where(varName).is(value));
				} else if (param instanceof Float) {
					float value = ((Float) param).floatValue();
					query.addCriteria(Criteria.where(varName).is(value));
				} else if (param instanceof Long) {
					long value = ((Long) param).longValue();
					query.addCriteria(Criteria.where(varName).is(value));
				} else if (param instanceof Boolean) {
					boolean value = ((Boolean) param).booleanValue();
					query.addCriteria(Criteria.where(varName).is(value));
				} else if (param instanceof Date) {
					Date value = (Date) param;
					query.addCriteria(Criteria.where(varName).is(value));
				} else if (param instanceof BigDecimal) {
					BigDecimal value = (BigDecimal) param;
					query.addCriteria(Criteria.where(varName).is(value));
				}
				field.setAccessible(accessFlag);
			}
		}
		if (isPage) {
			// 分页 从0开始
			if (start != null && length != null) {
				int index = (start / length);
				Pageable pageable = new PageRequest(index, length);
				query.with(pageable);
			}
		}
		// 排序
		if (StringUtils.isNotBlank(order)) {
			Sort sort = str2Sort(order);
			if (sort != null) {
				query.with(sort);
			}
		}

		log.debug(query.toString());
		return query;
	}

	/**
	 * 把Field[] 对象合并到List对象中
	 * 
	 * @param fields
	 * @return
	 */
	private static List<Field> combination2List(Field[]... fields) {
		List<Field> result = new ArrayList<>();
		if (fields != null) {
			for (Field[] field : fields) {
				if (field != null && field.length > 0) {
					for (Field f : field) {
						result.add(f);
					}
				}
			}
		}
		return result;
	}

	/**
	 * 是否是忽略的字段
	 * 
	 * @param obj
	 * @return
	 */
	private static boolean isIgnore(String obj) {
		return isIgnore(obj, ignore);
	}

	private static boolean isIgnore(String obj, String[] ignore) {
		boolean result = false;
		if (StringUtils.isNotBlank(obj)) {
			for (String i : ignore) {
				if (obj.equals(i)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private static Sort str2Sort(String str) {
		List<Order> orders = new ArrayList<>();
		if (StringUtils.isNotBlank(str)) {
			String[] arr = str.split(",");
			for (String s : arr) {
				String[] arr1 = s.split("\\s+");
				String property = "";
				Direction direction = Direction.DESC;
				property = arr1[0];
				if (arr1.length >= 2) {
					String dir = arr1[1];
					if ("asc".equalsIgnoreCase(dir)) {
						direction = Direction.ASC;
					}
				}
				if (StringUtils.isNotBlank(property)) {
					Order order = new Order(direction, property);
					orders.add(order);
				}
			}
		}
		if (orders != null && orders.size() > 0) {
			return new Sort(orders);
		}
		return null;
	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		/*AccessoryEntity entity=new AccessoryEntity();
		entity.setCreate_time(123456789L);
		entity.setId(123456789L);
		DBObject dbObject = QueryTool.bean2DBObject(entity);
		dbObject.markAsPartialObject();
		Map<String, Object> map = dbObject.toMap();
		System.out.println(dbObject);
		Goods goods = new Goods();
		goods.setName("123");
		String orders = "ctime     desc,xx     asc";
		System.out.println(str2Sort(orders));
		
		Account account=new Account();
		account.setUsername("123");
		
		ValidationResult result=ValidationUtils.validateEntity(account);
		System.out.println(result);
		*/
	}
}
