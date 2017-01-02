package com.miles.xiuda.dao;

import java.util.List;

import com.miles.xiuda.pojo.SysRoleMenu;

/**
 *  类名：SysRoleMenuDao.java
 *  说明：角色与菜单对应关系管理数据层
 *  创建时间：2016年12月31日 下午10:56:59
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu> {

	/**
	 * 根据角色ID，获取菜单ID列表
	 * 
	 * @param roleId
	 *            角色ID
	 * @return
	 */
	List<Long> queryMenuIdList(Long roleId);

}
