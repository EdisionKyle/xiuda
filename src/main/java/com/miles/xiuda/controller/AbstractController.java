package com.miles.xiuda.controller;

import com.miles.xiuda.pojo.SysUser;
import com.miles.xiuda.util.ShiroUtil;

/**
 *  类名：AbstractController.java
 *  说明：Controller抽象类
 *  创建时间：2017年1月1日 上午12:52:37
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public abstract class AbstractController {

	protected SysUser getUser() {
		return ShiroUtil.getSysUser();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

}
