package com.miles.xiuda.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  类名：DateUtil.java
 *  说明：基于 JDK 8 time包的时间工具类
 *  创建时间：2017年1月1日 上午12:37:58
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public class DateUtil {
	/**
	 * 获取默认日期格式: yyyy-MM-dd
	 */
	private static final DateTimeFormatter DATE_FORMATTER = TimeFormat.SHORT_DATE_PATTERN_LINE.formatter;
	/**
	 * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
	 */
	private static final DateTimeFormatter DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.formatter;

	private DateUtil() {
	}

	/**
	 * String转日期，格式yyyy-MM-dd
	 *
	 * @param dateStr
	 * @return
	 */
	public static LocalDateTime parseDate(String dateStr) {
		return LocalDateTime.parse(dateStr, DATE_FORMATTER);
	}

	/**
	 * String转时间，格式yyyy-MM-dd HH:mm:ss
	 *
	 * @param timeStr
	 * @return
	 */
	public static LocalDateTime parseTime(String timeStr) {
		return LocalDateTime.parse(timeStr, DATETIME_FORMATTER);
	}

	/**
	 * String 转时间
	 *
	 * @param timeStr
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static LocalDateTime parseTime(String timeStr, TimeFormat format) {
		return LocalDateTime.parse(timeStr, format.formatter);
	}

	/**
	 * 时间转String，格式yyyy-MM-dd HH:mm:ss
	 *
	 * @param time
	 * @return
	 */
	public static String parseTime(LocalDateTime time) {
		return DATETIME_FORMATTER.format(time);
	}

	/**
	 * 时间转String
	 *
	 * @param time
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String parseTime(LocalDateTime time, TimeFormat format) {
		return format.formatter.format(time);
	}

	/**
	 * 获取当前时间
	 *
	 * @return
	 */
	public static String getCurrentDatetime() {
		return DATETIME_FORMATTER.format(LocalDateTime.now());
	}

	/**
	 * 获取当前时间
	 *
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String getCurrentDatetime(TimeFormat format) {
		return format.formatter.format(LocalDateTime.now());
	}

	/**
	 * 时间格式定义
	 */
	public enum TimeFormat {

		/**
		 * 短时间格式
		 */
		SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
		SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
		SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
		SHORT_DATE_PATTERN_NONE("yyyyMMdd"),

		/**
		 * 长时间格式
		 */
		LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),
		LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
		LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
		LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),

		/**
		 * 长时间格式 带毫秒
		 */
		LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
		LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),
		LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),
		LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");

		private transient DateTimeFormatter formatter;

		TimeFormat(String pattern) {
			formatter = DateTimeFormatter.ofPattern(pattern);
		}
	}

}
