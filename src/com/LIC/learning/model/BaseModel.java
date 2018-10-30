package com.LIC.learning.model;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;

public class BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public <T> T toModel(Class<T> type) throws Exception {
		try {
			Constructor constructor = type.getConstructor();
			Object oModel = constructor.newInstance();
			BeanUtils.copyProperties(this, oModel);
			return type.cast(oModel);
		} catch (InvocationTargetException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (NoSuchMethodException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (InstantiationException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (IllegalAccessException e) {
			throw new Exception(e.getMessage(), e.getCause());
		}
	}

	public <T> T toForm(Class<T> type) throws Exception {
		try {
			Constructor constructor = type.getConstructor();
			Object oForm = constructor.newInstance();
			BeanUtils.copyProperties(this, oForm);
			return type.cast(oForm);
		} catch (InvocationTargetException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (NoSuchMethodException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (InstantiationException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (IllegalAccessException e) {
			throw new Exception(e.getMessage(), e.getCause());
		}

	}
}
