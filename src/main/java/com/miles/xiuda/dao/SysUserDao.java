package com.miles.xiuda.dao;

import java.util.List;
import java.util.Map;

import com.miles.xiuda.pojo.SysUser;

/**
 *  类名：SysUserDao.java
 *  说明：用户管理数据层
 *  创建时间：2016年12月31日 下午10:59:16
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysUserDao extends BaseDao<SysUser> {

	/**
	 * 查询用户的所有权限
	 * 
	 * @param userId
	 *            用户ID
	 */
	List<String> queryAllPerms(Long userId);

	/**
	 * 查询用户的所有菜单ID
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 根据用户名，查询系统用户
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	SysUser queryByUserName(String username);

	/**
	 * 修改密码
	 * 
	 * @param map
	 * @return
	 */
	int updatePassword(Map<String, Object> map);

}
