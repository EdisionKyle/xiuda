package com.miles.xiuda.dao;

import java.util.List;
import java.util.Map;

import com.miles.xiuda.pojo.SysMenu;

/**
 *  类名：SysMenuDao.java
 *  说明：菜单管理数据层
 *  创建时间：2016年12月31日 下午10:54:46
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public interface SysMenuDao extends BaseDao<SysMenu> {

	/**
	 * 根据父菜单，查询子菜单
	 * 
	 * @param parentId
	 *            父菜单ID
	 * @return
	 */
	List<SysMenu> queryListParentId(Long parentId);

	/**
	 * 获取不包含按钮的菜单列表
	 * 
	 * @return
	 */
	List<SysMenu> queryNotButtonList();
	
	/**
	 * 根据父菜单删除
	 * 
	 * @return
	 */
	int deleteByParentIds(Map<String, Object> param);

}
