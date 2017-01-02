package com.miles.xiuda.service;

import java.util.List;

/**
 *  类名：SysRoleMenuService.java
 *  说明：角色与菜单对应关系
 *  创建时间：2016年12月31日 下午11:12:29
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysRoleMenuService {

	void saveOrUpdate(Long roleId, List<Long> menuIdList);

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

}
