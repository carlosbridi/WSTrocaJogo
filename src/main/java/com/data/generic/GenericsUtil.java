package com.data.generic;

import java.lang.reflect.ParameterizedType;

public class GenericsUtil {
	@SuppressWarnings("rawtypes")
	public static Class getMappedSuperclass(final Class<?> clazz) {
		return getMappedSuperclass(clazz, 0);
	}

	@SuppressWarnings("rawtypes")
	public static Class getMappedSuperclass(final Class<?> clazz, int arg) {
		if (clazz.getGenericSuperclass() instanceof ParameterizedType) {
			ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
			return (Class) genericSuperclass.getActualTypeArguments()[arg];
		}

		return null;
	}
}
