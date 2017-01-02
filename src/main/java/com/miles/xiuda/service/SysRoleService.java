package com.miles.xiuda.service;

import java.util.List;
import java.util.Map;

import com.miles.xiuda.pojo.SysRole;

/**
 *  类名：SysRoleService.java
 *  说明：角色管理
 *  创建时间：2016年12月31日 下午11:14:52
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysRoleService {

	SysRole queryObject(Long roleId);

	List<SysRole> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(SysRole role);

	void update(SysRole role);

	void deleteBatch(Long[] roleIds);

}
