package com.miles.xiuda.dao;

import java.util.List;

import com.miles.xiuda.pojo.SysUserRole;

/**
 *  类名：SysUserRoleDao.java
 *  说明：用户与角色对应关系管理数据层
 *  创建时间：2016年12月31日 下午11:04:20
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysUserRoleDao extends BaseDao<SysUserRole> {

	/**
	 * 根据用户ID，获取角色ID列表
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	List<Long> queryRoleIdList(Long userId);

}
