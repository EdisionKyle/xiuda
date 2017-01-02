package com.miles.xiuda.util;

import java.util.HashMap;
import java.util.Map;

/**
 *  类名：Retmap.java
 *  说明：返回数据封装
 *  创建时间：2017年1月1日 上午1:06:34
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public class Retmap extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	/** 操作成功 */
	public static final String SUCCESS = "10000";
	/** 服务不可用 */
	public static final String UNKNOW_ERROR = "10001";
	/** 权限不足 */
	public static final String INSUFFICIENT_PERMISSION = "10002";
	/** 参数异常 */
	public static final String INVALID_PARAM = "10003";
	/** 业务处理失败 */
	public static final String BUSINESS_FAILURE = "40004";

	public Retmap() {
		put("code", "10000");
		put("msg", "操作成功");
	}

	public static Retmap error() {
		return error("10001", "未知异常，请联系管理员");
	}

	public static Retmap error(String msg) {
		return error("10001", msg);
	}

	public static Retmap error(String code, String msg) {
		Retmap r = new Retmap();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Retmap ok(String msg) {
		Retmap r = new Retmap();
		r.put("msg", msg);
		return r;
	}

	public static Retmap ok(Map<String, Object> map) {
		Retmap r = new Retmap();
		r.putAll(map);
		return r;
	}

	public static Retmap ok() {
		return new Retmap();
	}

	public Retmap put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public static void main(String[] args) {
		Retmap r = new Retmap();
		r.put("name", "meng520");
		r.put("age", 29);
		System.out.println(r.toString());
	}

}
