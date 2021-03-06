package com.murphy.springmvc.desensitize;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.murphy.springmvc.annotation.Desensitization;
import com.murphy.springmvc.enums.DesensitionType;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Wujun
 * @date 2019/12/18 18:11
 * @version 1.0
 */
@Log4j2
public class FastjsonDesensitizeFilter implements ValueFilter,DesensitizeService {
	@Override
	public Object process(Object object, String name, Object value) {
		if (null == value || !(value instanceof String) || ((String) value).length() == 0) {
			return value;
		}
		try {
			Field field = object.getClass().getDeclaredField(name);
			Desensitization desensitization;
			if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
				return value;
			}
			;
			DesensitionType type = desensitization.type();
			List<String> regular=this.desensitize(type,desensitization);
			if (regular.size() > 1) {
				String match = regular.get(0);
				String result = regular.get(1);
				if (null != match && result != null && match.length() > 0) {
					return ((String) value).replaceAll(match, result);
				}
			}
		} catch (Exception e) {
			log.warn("FastJsonDesensitizeFilter the class {} has no field {}", object.getClass(), name);
		}
		return value;
	}
}
