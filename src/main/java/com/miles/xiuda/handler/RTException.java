package com.miles.xiuda.handler;

/**
 *  类名：RTException.java
 *  说明：异常类
 *  创建时间：2017年1月1日 上午2:01:05
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public class RTException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/** 返回码 */
	private String code;
	/** 描述信息 */
	private String msg;

	public RTException() {
		super();
	}

	public RTException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public RTException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public RTException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
