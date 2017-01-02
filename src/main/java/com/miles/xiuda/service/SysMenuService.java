package com.miles.xiuda.service;

import java.util.List;
import java.util.Map;

import com.miles.xiuda.pojo.SysMenu;

/**
 *  类名：SysMenuService.java
 *  说明：菜单管理服务层接口
 *  创建时间：2016年12月31日 下午11:09:56
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysMenuService {

	/**
	 * 根据父菜单，查询子菜单
	 * 
	 * @param parentId
	 *            父菜单ID
	 * @param menuIdList
	 *            用户菜单ID
	 */
	List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenu> queryNotButtonList();

	/**
	 * 获取用户菜单列表
	 */
	List<SysMenu> getUserMenuList(Long userId);

	/**
	 * 查询菜单
	 */
	SysMenu queryObject(Long menuId);

	/**
	 * 查询菜单列表
	 */
	List<SysMenu> queryList(Map<String, Object> map);

	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存菜单
	 */
	void save(SysMenu menu);

	/**
	 * 修改
	 */
	void update(SysMenu menu);

	/**
	 * 删除
	 */
	void deleteBatch(Long[] menuIds);

}
