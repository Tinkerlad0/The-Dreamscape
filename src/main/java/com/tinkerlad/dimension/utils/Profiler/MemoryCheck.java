package com.tinkerlad.dimension.utils.Profiler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MemoryCheck {

	public static final String B = "B";
	public static final String KB = "KB";
	public static final String MB = "MB";

	String size() default KB;
}    // interface MemoryCheck