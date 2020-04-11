package com.nvt.utils;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class FormUtil {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> T toModel(Class<T> tclass, HttpServletRequest request){
		T object = null;
		try {
			
			DateConverter converter = new DateConverter( null );
			converter.setPattern("yyyy-MM-dd");
			ConvertUtils.register(converter, java.sql.Timestamp.class);
			object = tclass.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.print(e.getMessage());
		}
		return object;
	}

}
