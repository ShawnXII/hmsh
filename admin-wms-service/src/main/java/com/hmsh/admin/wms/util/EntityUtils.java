package com.hmsh.admin.wms.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class EntityUtils {

	@SuppressWarnings({"rawtypes" })
	public static Class getEntityClass(Class entity, int index) {
		if (null == entity)
			return null;
		if (Object.class.equals(entity))
			return (Class) Object.class;

		ParameterizedType type = (ParameterizedType) entity.getGenericSuperclass();
		if (null == type)
			return (Class) Object.class;
		Type[] types = type.getActualTypeArguments();
		if (null == types || types.length == 0)
			return (Class) Object.class;
		if (index > -1) {
			return (Class) (index < types.length ? types[index] : types[types.length - 1]);
		} else {
			return (Class) types[0];
		}
	}
	
	@SuppressWarnings({"rawtypes" })
	public static  Class getEntityClass(Class entity) {
		return getEntityClass(entity, 0);
	}

}
