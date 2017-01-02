package com.miles.xiuda.service;

import java.util.List;

/**
 *  类名：SysUserRoleService.java
 *  说明：用户与角色对应关系
 *  创建时间：2016年12月31日 下午11:15:16
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysUserRoleService {
	
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
	
	void delete(Long userId);
}
