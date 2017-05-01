package com.hmsh.core.base.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmsh.admin.vo.user.Account;
import com.hmsh.core.base.vo.Entity;
import com.hmsh.core.exception.DaoException;
import com.hmsh.core.tool.Commutil;

public class SqlProvider {

	private static final Logger log = LoggerFactory.getLogger(SqlProvider.class);

	private static final String INSERT_SQL = "INSERT INTO";

	private static final String UPDATE_SQL = "UPDATE";

	private static final String DETELE_SQL = "DELETE FROM";

	private static final String SELECT_SQL = "SELECT";

	/**
	 * 插入一条数据
	 * 
	 * @param bean
	 */
	public <T extends Entity<PK>, PK extends java.io.Serializable> String insert(T bean) throws DaoException {
		List<T> list = new ArrayList<>();
		list.add(bean);
		return insertList(list);
	}

	/**
	 * 插入多条数据
	 * 
	 * @param clz
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T extends Entity<PK>, PK extends java.io.Serializable> String insertList(List<T> lists)
			throws DaoException {
		if (lists == null || lists.size() < 1) {
			throw new DaoException("插入对象不能为空!");
		}
		T bean = lists.get(0);
		Class<? extends Entity> beanClass = bean.getClass();
		String tablename = getTableName(beanClass);
		StringBuilder insertSql = new StringBuilder(INSERT_SQL);
		insertSql.append(" ").append(tablename).append(" ( ");
		int h = 0, size = lists.size();
		List<String> insertParaNames = new ArrayList<String>();
		for (T entity : lists) {
			if (entity.getId() == null) {
				PK id = (PK) Commutil.generateId();
				entity.setId(id);
			}
			Class<? extends Entity> clazz = entity.getClass();
			Field[] fields = getFields(clazz);
			List<String> insertParas = new ArrayList<String>();

			for (Field field : fields) {
				boolean accessible = field.isAccessible();
				if (!accessible) {
					field.setAccessible(true);
				}
				try {
					String name = field.getName();
					Column column = field.getAnnotation(Column.class);
					if (column != null && StringUtils.isNotBlank(column.name())) {
						name = column.name();
					}
					Object obj = field.get(entity);

					NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
					if (notEmpty != null) {
						if (obj == null) {
							throw new DaoException(notEmpty.message());
						}
					}
					if (isWrapClass(field.getType()) || field.getType() == String.class) {
						if (h == 0) {
							insertParaNames.add(name);
						}
						insertParas.add("#{" + field.getName() + "}");
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					new RuntimeException("get insert sql is exceptoin:" + e);
				} finally {
					field.setAccessible(accessible);
				}
			}

			int i = 0, len = insertParaNames.size(), k = 0, len1 = insertParas.size();
			if (insertParaNames == null || len < 1 || insertParas == null || len1 < 1 || len != len1) {
				throw new DaoException("反射获取字段失败!");
			}
			if (h == 0) {
				for (String str : insertParaNames) {
					insertSql.append(" ").append(str);
					if (i != len - 1) {
						insertSql.append(" , ");
					}
					i++;
				}
				insertSql.append(" ) ").append(" VALUES (");
			}
			for (String str : insertParas) {
				insertSql.append(" ").append(str);
				if (k != len1 - 1) {
					insertSql.append(" , ");
				}
				k++;
			}
			insertSql.append(")");
			if (h != size - 1) {
				insertSql.append(",");
			}
			h++;
		}
		if (log.isDebugEnabled()) {
			log.debug("insert sql:" + insertSql.toString());
		}
		return insertSql.toString();
	}

	/**
	 * 修改
	 * 
	 * @param bean
	 * @return
	 * @throws DaoException
	 */
	public <T extends Entity<PK>, PK extends java.io.Serializable> String update(T bean) throws DaoException {
		return buildUpdateSql(bean, false);
	}

	/**
	 * 修改不为null的
	 * 
	 * @param bean
	 * @return
	 * @throws DaoException
	 */
	public <T extends Entity<PK>, PK extends java.io.Serializable> String updateNotNull(T bean) throws DaoException {
		return buildUpdateSql(bean, true);
	}

	/**
	 * 根据条件删除
	 * 
	 * @param bean
	 * @return
	 * @throws DaoException
	 */
	public <T extends Entity<PK>, PK extends java.io.Serializable> String remove(T bean) throws DaoException {
		Class<?> beanClass = bean.getClass();
		String tableName = getTableName(beanClass);
		Field[] fields = getFields(beanClass);
		StringBuilder deleteSql = new StringBuilder(DETELE_SQL);
		deleteSql.append(" ").append(tableName).append(" where  ");
		int i = 0;
		for (Field field : fields) {
			boolean accessible = field.isAccessible();
			if (!accessible) {
				field.setAccessible(true);
			}
			try {
				String name = field.getName();
				Column column = field.getAnnotation(Column.class);
				if (column != null && StringUtils.isNotBlank(column.name())) {
					name = column.name();
				}
				Object obj = field.get(bean);
				if (isWrapClass(field.getType()) || field.getType() == String.class) {
					if (obj != null) {
						deleteSql.append(name).append("=#{").append(field.getName()).append("}");
						deleteSql.append(" !@AND!@ ");
						i++;
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				new RuntimeException("get insert sql is exceptoin:" + e);
			} finally {
				field.setAccessible(accessible);
			}
		}
		if (i == 0) {
			throw new DaoException("找不到删除条件!");
		}
		String sql = deleteSql.toString();
		sql = sql.substring(0, sql.lastIndexOf("!@AND!@")).replaceAll("!@AND!@", "AND");
		return sql;
	}

	/**
	 * 查询
	 * 
	 * @return
	 * @throws DaoException
	 */
	public <T extends Entity<PK>, PK extends java.io.Serializable> String find(T bean) throws DaoException {
		Class<?> beanClass = bean.getClass();
		String tableName = getTableName(beanClass);
		Field[] fields = getFields(beanClass);
		StringBuilder selectSql = new StringBuilder(SELECT_SQL);
		List<String> selectParaNames = new ArrayList<String>();
		List<String> selectParas = new ArrayList<String>();
		for (Field field : fields) {
			boolean accessible = field.isAccessible();
			if (!accessible) {
				field.setAccessible(true);
			}
			try {
				String name = field.getName();
				Column column = field.getAnnotation(Column.class);
				if (column != null && StringUtils.isNotBlank(column.name())) {
					name = column.name();
				}
				Object obj = field.get(bean);
				if (isWrapClass(field.getType()) || field.getType() == String.class) {
					selectSql.append(" ").append(name).append(" , ");
					if (obj != null) {
						selectParaNames.add(name);
						selectParas.add("#{" + field.getName() + "}");
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				new RuntimeException("get select sql is exceptoin:" + e);
			} finally {
				field.setAccessible(accessible);
			}
		}
		String sql = selectSql.toString();
		sql = sql.substring(0, sql.lastIndexOf(","));
		selectSql = new StringBuilder(sql);
		selectSql.append(" from ").append(tableName);
		if(selectParaNames!=null&&selectParaNames.size()>0){
			selectSql.append(" where ");
			for (int i = 0; i < selectParaNames.size(); i++) {
				selectSql.append(selectParaNames.get(i)).append(" = ").append(selectParas.get(i));
				if (i != selectParaNames.size() - 1) {
					selectSql.append(" AND ");
				}
			}
		}
		
		return selectSql.toString();
	}
	/**
	 * 修改
	 * 
	 * @param list
	 * @return
	 * @throws DaoException
	 */
	private <T extends Entity<PK>, PK extends java.io.Serializable> String buildUpdateSql(T bean, boolean isNotNull)
			throws DaoException {
		Class<?> beanClass = bean.getClass();
		String tableName = getTableName(beanClass);
		Field[] fields = getFields(beanClass);
		StringBuilder updateSql = new StringBuilder(UPDATE_SQL);
		updateSql.append(" ").append(tableName).append(" set ");
		if (bean.getId() == null) {
			throw new DaoException("没有主键信息,无法修改!");
		}
		List<String> idColumns = new ArrayList<>();
		List<Object> idValues = new ArrayList<>();
		int i = 0;
		for (Field field : fields) {
			boolean accessible = field.isAccessible();
			if (!accessible) {
				field.setAccessible(true);
			}
			try {
				String name = field.getName();
				Column column = field.getAnnotation(Column.class);
				if (column != null && StringUtils.isNotBlank(column.name())) {
					name = column.name();
				}
				Object obj = field.get(bean);
				Id ID = field.getAnnotation(Id.class);
				if (ID != null) {
					if (obj != null) {
						idColumns.add(name);
						idValues.add(field.getName());
					}
					continue;
				} else if ("id".equalsIgnoreCase(field.getName()) || "dmid".equalsIgnoreCase(field.getName())) {
					if (obj != null) {
						idColumns.add(name);
						idValues.add(field.getName());
					}
					continue;
				}
				if (isWrapClass(field.getType()) || field.getType() == String.class) {
					if (isNotNull) {
						if (obj != null) {
							updateSql.append(name).append("=#{").append(field.getName()).append("}").append(",");
							i++;
						}
					} else {
						updateSql.append(name).append("=#{").append(field.getName()).append("}").append(",");
						i++;
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				new RuntimeException("get insert sql is exceptoin:" + e);
			} finally {
				field.setAccessible(accessible);
			}
		}
		if (i == 0) {
			throw new DaoException("沒有需要修改的字段！");
		}
		String sql = updateSql.toString();
		sql = sql.substring(0, sql.lastIndexOf(","));
		updateSql = new StringBuilder(sql);
		if (idColumns.size() < 1) {
			throw new DaoException("没有主键信息,无法修改!");
		}
		updateSql.append(" where ");
		for (i = 0; i < idColumns.size(); i++) {
			String id = idColumns.get(i);
			updateSql.append(id).append(" = #{").append(idValues.get(i)).append("} ");
			if (i != idColumns.size() - 1) {
				updateSql.append(" AND ");
			}
		}
		return updateSql.toString();
	}

	private boolean isWrapClass(Class<?> clz) {
		try {
			return ((Class<?>) clz.getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}

	private <PK extends java.io.Serializable> String getTableName(Class<?> beanClass) {
		String tableName = "";
		Table table = beanClass.getAnnotation(Table.class);
		if (table != null && StringUtils.isNotBlank(table.schema())) {
			tableName = table.schema() + ".";
		}
		if (table != null && StringUtils.isNotBlank(table.name())) {
			tableName += table.name();
		} else {
			tableName = Commutil.underscoreName(beanClass.getSimpleName());
		}
		return tableName;
	}

	/**
	 * 获取全部字段属性
	 * 
	 * @param beanClass
	 * @return
	 */
	private Field[] getFields(Class<?> beanClass) {
		Field[] beanFields = beanClass.getDeclaredFields();
		Class<?> beanSuperClass = beanClass.getSuperclass();
		Field[] beanSuperFields = beanSuperClass.getDeclaredFields();
		List<Field> result = new ArrayList<>();
		Field[][] fields = new Field[][] { beanFields, beanSuperFields };
		if (fields != null) {
			for (Field[] field : fields) {
				if (field != null && field.length > 0) {
					for (Field f : field) {
						result.add(f);
					}
				}
			}
		}
		return result.toArray(new Field[result.size()]);
	}

	public static void main(String[] args) throws DaoException {
		SqlProvider sql = new SqlProvider();
		Account account = new Account();
		account.setUsername("1");
		account.setSalt("");
		System.out.println(sql.remove(account));
	}

}
