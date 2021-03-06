package com.monitor.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRes {
	String name() default "";
	String code() default "";
	Class<?> clazz() default String.class;
	String value() default "";
	String pCode() default "";
}